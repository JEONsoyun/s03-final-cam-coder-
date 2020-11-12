function btn_build(){
    var url = "http://localhost:3000/cbuild"
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