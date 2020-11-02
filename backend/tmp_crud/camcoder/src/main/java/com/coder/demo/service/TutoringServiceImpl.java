package com.coder.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.coder.demo.component.TutorRegistRequest;
import com.coder.demo.dao.TeacherDAO;
import com.coder.demo.dao.TutoringDAO;
import com.coder.demo.dao.UserDAO;
import com.coder.demo.exception.NotExistIdException;
import com.coder.demo.vo.Teacher;
import com.coder.demo.vo.Tutoring;
import com.coder.demo.vo.User;

@Service
public class TutoringServiceImpl implements TutoringService {
	private final AtomicInteger roomnum = new AtomicInteger();

	@Autowired
	TutoringDAO tutoringdao;

	@Autowired
	UserDAO userdao;

	@Autowired
	TeacherDAO tdao;


	@Override
	public Tutoring selectOne(Long tutoringCode) {
		return tutoringdao.findById(tutoringCode).get();
	}

	@Override
	public List<Tutoring> selectAll(String id) {
		return null;//status가 인트여야 가능하다!!!!!!!정렬을 그래야 할 수 있다구(status 정렬, 튜터링 코드 정렬)
		//return tutoringdao.findByStudentCode(code);
	}

	@Override
	public void insert(TutorRegistRequest regist, String id) throws Exception {
		User student = Optional.ofNullable(userdao.findByUserId(id)).orElseThrow(NotExistIdException::new);		

		Long tcode = Optional.ofNullable(regist).map(TutorRegistRequest::getTeacher_code).orElse((long)0);
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tcode)).orElseThrow(() -> new NotExistIdException("teacher"));
		
		try {
			//String content = Optional.of(regist).map(TutorRegistRequest::getContent).orElse("");
			//Long price = Optional.of(regist).map(TutorRegistRequest::getPrice).orElse((long)0);
			Date starttime = Optional.of(regist).map(TutorRegistRequest::getStart).orElse(new Date());
			Date endtime = Optional.of(regist).map(TutorRegistRequest::getEnd).orElse(new Date());

			////////////////////////////////status enum배워서 넣기
			Tutoring now = new Tutoring(starttime, endtime, "요청중", roomnum.getAndIncrement());

			//studentCnt 증가
			tc.addTutor(now);
			student.addTutor(now);

			tutoringdao.save(now);

		}catch(DataAccessException ex) {
			ex.printStackTrace();
			System.out.println(ex.getCause().getMessage());
		}

	}

	@Override
	public void update(TutorRegistRequest regist, String id, Long tutoringCode) throws Exception {
		Tutoring now = Optional.ofNullable(tutoringdao.findByTutoringCode(tutoringCode)).orElseThrow(() -> new NotExistIdException("tutoring"));

		//요청 사용자
		User user = Optional.ofNullable(userdao.findByUserId(id)).orElseThrow(NotExistIdException::new);		

		//tutoring 정보
		Long tcode = Optional.ofNullable(now.getTeacher()).map(Teacher::getTeacherCode).orElseThrow(() -> new NotExistIdException("teacher"));
		Teacher tc = Optional.ofNullable(tdao.findByTeacherCode(tcode)).orElseThrow(() -> new NotExistIdException("teacher"));
		
		Long scode = Optional.ofNullable(now.getStudent()).map(User::getUserCode).orElseThrow(() -> new NotExistIdException("student"));

		//선생님만 수락, 완료 가능?
		if(user.getUserCode() == tc.getUser().getUserCode()) {
			System.out.println("teacher");
			try {
				Integer type = Optional.of(regist).map(TutorRegistRequest::getStatus).orElse(0);

				if(type == 1&& (now.getStatus().equals("요청중"))) {
					now.setStatus("확인");
					//studentCnt 증가
					tc.setTutor(now);
				}else if(type == 2&& (now.getStatus().equals("확인"))){
					now.setStatus("완료");
				}else if(type == 3&& (now.getStatus().equals("요청중"))) {
					now.setStatus("거절");
				}			

				tutoringdao.save(now);

			}catch(DataAccessException ex) {
				ex.printStackTrace();
				System.out.println(ex.getCause().getMessage());
			}		
		}else {
			try {
				Integer type = Optional.of(regist).map(TutorRegistRequest::getStatus).orElse(0);

				if(type == 2&& (now.getStatus().equals("확인"))){
					now.setStatus("완료");
				}else if(type == 3 && (now.getStatus().equals("요청중"))) {
					now.setStatus("거절");
				}

				tutoringdao.save(now);

			}catch(DataAccessException ex) {
				ex.printStackTrace();
				System.out.println(ex.getCause().getMessage());
			}
		}
		
	}

	@Override
	public List<Tutoring> selectAllTutee(String id) throws NotExistIdException {
		Long ucode = Optional.ofNullable(userdao.findByUserId(id)).map(User::getUserCode).orElseThrow(NotExistIdException::new);		
		Long tcode = Optional.ofNullable(tdao.findByUserCode(ucode)).map(Teacher::getTeacherCode).orElseThrow(() -> new NotExistIdException("teacher"));
		
		System.out.println("teacher code : " + tcode);
		return tutoringdao.findByTeacherCode(tcode);
	}

	@Override
	public List<Tutoring> selectAllTutor(String id) throws NotExistIdException{
		Long ucode = Optional.ofNullable(userdao.findByUserId(id)).map(User::getUserCode).orElseThrow(NotExistIdException::new);		

		System.out.println("student code : " + ucode);
		return tutoringdao.findByStudentCode(ucode);
	}



}
