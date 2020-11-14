function btn_build(){
    var url = "http://k3a110.p.ssafy.io:8081/cbuild"
    var code = document.querySelector("#code").value;
	var lang = document.querySelector("#language");
	var selectedLang = lang.options[lang.selectedIndex].value;
    var data = {'code': code, 'lang': selectedLang};
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
