function btn_build(){
    var url = "http://k3a110.p.ssafy.io:8081/cbuild"
    var code = document.querySelector("#code").value;
    var data = {'code': code};
    data = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(data);

    xhr.addEventListener('load', () => {
        var result = JSON.parse(xhr.responseText);
        document.getElementById('output').value = result.output;
    });
};
