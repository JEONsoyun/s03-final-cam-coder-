/* pipeline 변수 설정 */
def DOCKER_IMAGE_NAME = "wlgh325/project-camcoder"
def DOCKER_IMAGE_TAGS = "0.2"
def NAMESPACE = "camcoder-project"
def VERSION = "${env.BUILD_NUMBER}"
def DEPLOY_NAME = "camcoder-spring"
def HELM_CHART_DIR = "springboot"
def DATE = new Date();

podTemplate(label: 'builder',
            containers: [
                containerTemplate(name: 'maven', image: 'maven:3.6-jdk-11-slim', command: 'cat', ttyEnabled: true),
                containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),
                containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.15.3', command: 'cat', ttyEnabled: true),
                containerTemplate(name: 'helm', image: 'dtzar/helm-kubectl', command: 'cat', ttyEnabled: true)
            ],
            volumes: [
                hostPathVolume(mountPath: '/home/env', hostPath: '/home/ubuntu/env'),
                hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
            ]) {
        node('builder') {
            stage('Checkout') {
                checkout scm
            }
            stage('Build') {
                container('maven') {
                    dir('backend/tmp_crud/camcoder'){
                        sh "ls -al"
                        sh "ls /home/env"
						sh "mvn package"
					}
                }
            }
            stage('Docker build') {
                container('docker') {
                    withCredentials([usernamePassword(
                        credentialsId: 'docker_hub_auth',
                        usernameVariable: 'USERNAME',
                        passwordVariable: 'PASSWORD')]) {
						    dir('backend/tmp_crud/camcoder'){
						        sh "ls -al"
                                sh "docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAGS} ."
                                sh "docker login -u ${USERNAME} -p ${PASSWORD}"
                                sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAGS}"
							}
                        }
                }
            }
			stage('Clean up current deployments'){
				container('helm') {
					try{
						sh "helm delete ${DEPLOY_NAME} -n ${NAMESPACE}"
					}
					catch (e) {
						echo "Clear-up Error: " + e.getMessage()
						echo "Continue Process !"
					}
				}
			}
            stage('deploy to cluster') {
                container('helm') {
                    withCredentials([usernamePassword(
                        credentialsId: 'docker_hub_auth',
                        usernameVariable: 'USERNAME',
                        passwordVariable: 'PASSWORD')]) {
                            sh "kubectl get ns ${NAMESPACE} || kubectl create ns ${NAMESPACE}"

                            sh """
                                kubectl get secret my-secret -n ${NAMESPACE} || \
                                kubectl create secret docker-registry my-secret \
                                --docker-server=https://index.docker.io/v1/ \
                                --docker-username=${USERNAME} \
                                --docker-password=${PASSWORD} \
                                --docker-email=wlgh325@gmail.com \
                                -n ${NAMESPACE}
                            """
                            
                            //sh "echo ${DATE}"
                            //sh "sed -i.bak 's$DATE_STRING#${DATE}#' ./k8s/k8s-deployment.yaml

							dir('helm'){
								echo "Install with chart file !"
						        sh "ls -al"
                                sh "helm install ${DEPLOY_NAME} ${HELM_CHART_DIR} --namespace ${NAMESPACE}"
							}
                        }
                }
            }
			post{
				always{
					step([$class: 'WsCleanup'])
				}
			}
        }
}
