var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var pg = require('pg');
const pool = require("./db")

app.use(express.json())


/* app.get('/', function(req, res){
    res.send('Hola Putitos!');
}); */

app.get("/usuarios", async(req, res)=>{
    try{
        const usuarios = await pool.query("SELECT * FROM usuario");
        res.json(usuarios.rows)

    }catch(err) {
        console.error(err.message);

    }

});


app.listen(5000);
console.log('API running on port 5000')