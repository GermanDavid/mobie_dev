const express = require('express')
const app = express();
const port = 3000;

// Set up the template engine
app.set('view engine', 'ejs');

app.get('/', (req, res) => {
  res.render('app')
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}!`)
});