var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var pg = require('pg');
const pool = require("./db")

app.use(express.json())

const PORT = 8080;
const HOST = '0.0.0.0';

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

app.get("/usuarios/:id", async(req, res)=>{
    const { id } = req.params
    try{
        const usuarios = await pool.query("SELECT * FROM usuario WHERE \"ID\" = $1", [id]);
        res.json(usuarios.rows)

    }catch(err) {
        console.error(err.message);

    }

});


app.get("/logIn/:correo", async(req, res)=>{
    const { correo } = req.params
    try{
        const contra = await pool.query("SELECT contrasenna FROM usuario WHERE correo = $1", [correo]);
        res.json(contra.rows)

    }catch(err) {
        console.error(err.message);

    }

});

app.get("/logIn/:correo", async(req, res)=>{
    const { correo } = req.params
    try{
        const contra = await pool.query("SELECT contrasenna FROM usuario WHERE correo = $1", [correo]);
        res.json(contra.rows)

    }catch(err) {
        console.error(err.message);

    }

});

app.get("/cursos", async(req, res)=>{
    try{
        const cursos = await pool.query("SELECT curso.codigo, clase FROM curso INNER JOIN grado ON curso.\"gradoId\" = grado.\"ID\"");
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});

app.get("/cursos/estudiante/:estId", async(req, res)=>{
    const { estId } = req.params
    try{
        const cursos = await pool.query("SELECT codigo, clase FROM \"cursoXestudiante\" INNER JOIN curso ON \"cursoXestudiante\".\"cursoId\" = curso.\"ID\" INNER JOIN grado ON curso.\"gradoId\" = grado.\"ID\" WHERE \"estudianteId\" $1", [estId]);
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});


app.listen(PORT, HOST);
console.log('API running on port 8080')