const ShareDB = require('sharedb');
const richText = require('rich-text');
const WebSocket = require('ws');
const WebSocketJSONStream = require('@teamwork/websocket-json-stream');

module.exports = server => {
  ShareDB.types.register(richText.type);
  const backend = new ShareDB();
  createDoc(startServer);

  function createDoc(callback) {
    const connection = backend.connect();
    const doc = connection.get('examples', 'richtext');
    doc.fetch(function(err) {
      if (err) throw err;
      if (doc.type === null) {
        doc.create([{insert: 'Hi!'}], 'rich-text', callback);
        return;
      }
      callback();
    });
  }

  function startServer() {
    const wss = new WebSocket.Server({
      server: server,
      path: '/realtime',
    });
    wss.on('connection', function(ws) {
      const stream = new WebSocketJSONStream(ws);
      backend.listen(stream);
    });
  }
};
