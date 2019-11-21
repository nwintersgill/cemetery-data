/*
 * This example is from 
 * http://www.tutorialspoint.com/nodejs/nodejs_express_framework.htm
 * 2016-07-25
 *
 * Revised: 2019-09-26
 *
 * This is an HTTP server using 'express' which can accept multiple
 * types of requests (hard-coded) as follows.
 *  - '/'               responds with the 'Hello World' string
 *  - '/form.html'      responds with the file 'form.html' which contains
 *                      the form in which user can fill in two strings.
 *                      The form also calls /process_get when it is submitted.
 *
 * Run the program as
 * node express-server.js
 *
 * Sample requests from a client such as a browser
 *  1. http://localhost:8081/          displays the "Hello World" message
 *  2. http://localhost:8081/form.html displays the form for input
 */
const home = "";
var express = require(home + 'express');
var app = express();

var bodyParser = require(home + 'body-parser');

// Create application/x-www-form-urlencoded parser
var urlencodedParser = bodyParser.urlencoded({ extended: false })

app.use(express.static('public'));

// accept request of the type 'http://host/' only, no path after '/'
app.get('/', function (req, res) {
	console.log('requesting host : ' + req.hostname);
	/*message = '<p>Hello World!</p>'
		+ '<p>Copy the program and data files from the Linux command line</p>'
		+ '<code>% cp -r ~cs479/public_html/2019-fall/code-examples/node-js/ .</code>'*/
	res.sendFile(__dirname + '/' + 'map_gui.html');
})

// accept the request for the 'form.html' file which allows user inputs
app.get('/form.html', function (req, res) {
   console.log('requesting host : ' + req.hostname);
   /*
    Note: the sendFile() function requires an absolute path to the file!
    */
   res.sendFile(__dirname + '/' + 'form.html');
   
   // the following doesn't work!
//   res.sendFile('form.html');
})

// accept a form GET input with processing being '/process_get', see form.html
app.get('/process_get', function (req, res) {

   // Prepare output in JSON format
   response = {
       first_name:req.query.first_name,
       last_name:req.query.last_name
   };
   console.log('Request: GET /process_get');
   console.log(response);
   res.end(JSON.stringify(response));
})

// accept a form POST input with processing being '/process_get', see form.html
app.post('/process_post', urlencodedParser, function (req, res) {

   // Prepare output in JSON format
   response = {
       first_name:req.body.first_name,
       last_name:req.body.last_name
   };
   console.log('Request: POST /process_get');
   console.log(response);
   res.end(JSON.stringify(response));
})

var server = app.listen(8081, function () {

  var host = server.address().address;
  var port = server.address().port;

  console.log("Example app listening at http://%s:%s", host, port);

})

/*
 * The content of form.html is listed for reference.
 *
<html>
<body>
<form action="http://localhost:8081/process_post" method="POST">
<!--
<form action="http://localhost:8081/process_get" method="GET">
-->
First Name: <input type="text" name="first_name">  <br>

Last Name: <input type="text" name="last_name">
<input type="submit" value="Submit">
</form>
</body>
</html>
 */
