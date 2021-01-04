const express = require('express');
const fs = require('fs');

// Initialize the app
let app = express();
app.use(express.static('./images'));
let path = require('path');

/**
 *  The app will listen to all incoming requests, and will return the corresponding file or a message the file doesn't exists.
 *  It will be done by piping the file to the result as instructed
 **/ 

app.get('/files/:name', (req,res) => {
    
    let fileName = (req.params['name'] || null);

    // Check if the file exist
    if(!fileName){ 
        res.send("No such a filename");
        return; 
    }

    //Create a path for the file
    let filePath = path.join('./images/', fileName);

    //Check if this file exists in images folder
    if(!(fs.existsSync(filePath))){ 
        res.send("404 Not Found : (");
        return; 
    }
    //If the file exist pipe it to the response.
    fs.createReadStream(filePath).pipe(res);
});

app.listen(3000,() => {
    console.log('Listening on port 3000!')});