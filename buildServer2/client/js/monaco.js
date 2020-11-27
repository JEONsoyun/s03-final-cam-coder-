var editor;
require.config({ paths: { 'vs': 'https://cdnjs.cloudflare.com/ajax/libs/monaco-editor/0.16.2/min/vs' }});

require(['vs/editor/editor.main'], function() {
    editor = monaco.editor.create(document.getElementById('monaco'), {
        theme: 'vs-dark',
        fontFamily: 'Nanum Gothic Coding',
        automaticLayout: true,
        language: 'c',
        value: [
        '#include <stdio.h>',
        'void main() {',
        '}'
        ].join('\n')
    });
});
