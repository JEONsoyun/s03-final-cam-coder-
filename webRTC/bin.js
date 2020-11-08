const debug = require("debug")("bin");
const app = require('./app');
const port = process.env.port || 3001;
require('./socket.js');

app.listen(port, () => {
  debug(`Server running at http://*::${port}/`);
});
