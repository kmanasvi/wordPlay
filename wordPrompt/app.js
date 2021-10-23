var express = require('express');

var app = express();

const http = require("https");

const app_id = "d3c927b4"; // insert your APP Id
const app_key = "c3430283b719e1005dcf112b5696cbdd"; // insert your APP Key
const wordId = "ace";
const fields = "pronunciations";
const strictMatch = "false";

const options = {
  host: 'od-api.oxforddictionaries.com',
  port: '443',
  path: '/api/v2/entries/en-gb/' + wordId + '?fields=' + fields + '&strictMatch=' + strictMatch,
  method: "GET",
  headers: {
    'app_id': app_id,
    'app_key': app_key
  }
};

let body = '';
let parsed = '';
http.get(options, (resp) => {
    resp.on('data', (d) => {
        body += d;
    });
    resp.on('end', () => {
        parsed = JSON.stringify(body);
        console.log(parsed);
    });
});
app.get('/', function (req, res) {
  res.send(parsed);
});
app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});