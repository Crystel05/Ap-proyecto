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

//Prueba para lista de resultados
app.get("/usuarios", async(req, res)=>{
    try{
        const usuarios = await pool.query("SELECT * FROM usuario");
        res.json(usuarios.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Prueba resultado especifico
app.get("/usuarios/:id", async(req, res)=>{
    const { id } = req.params
    try{
        const usuarios = await pool.query("SELECT * FROM usuario WHERE \"ID\" = $1", [id]);
        res.json(usuarios.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Log in
app.get("/logIn/:correo", async(req, res)=>{
    const { correo } = req.params
    try{
        const contra = await pool.query("SELECT contrasenna FROM usuario WHERE correo = $1", [correo]);
        res.json(contra.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Dar todos los cursos a Admin
app.get("/cursos", async(req, res)=>{
    try{
        const cursos = await pool.query("SELECT curso.codigo, clase FROM curso INNER JOIN grado ON curso.\"gradoId\" = grado.\"ID\"");
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});


//Dar todos los cursos a Estudiantes con su correo
app.get("/cursos/estudiante/:estCorreo", async(req, res)=>{
    const { estCorreo } = req.params
    try{
        const cursos = await pool.query("SELECT * FROM cursosEstudiante($1)", [estCorreo]);
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Dar todos los cursos a Profesores con su correo
app.get("/cursos/profesor/:profCorreo", async(req, res)=>{
    const { profCorreo } = req.params
    try{
        const cursos = await pool.query("SELECT * FROM cursosProfesor($1)", [profCorreo]);
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Detalles de los cursos segun codigo y clase(Admin)
app.get("/cursos/info/:cod/:clase", async(req, res)=>{
    const { cod } = req.params
    const { clase } = req.params
    try{
        const cursos 
        = await pool.query("SELECT codigo, nombre, clase, \"horaInicio\", \"horaFin\", \"diaSemana\"FROM curso INNER JOIN grado ON \"gradoId\" = grado.\"ID\" WHERE codigo = $1 AND clase = $2;", [cod,clase]);
        res.json(cursos.rows)

    }catch(err) {
        console.error(err.message);

    }

});


//Lista de todos los profesores
app.get("/profesores", async(req, res)=>{
    try{
        const usuarios = await pool.query("SELECT usuario.nombre, usuario.cedula FROM profesor INNER JOIN usuario ON profesor.\"usuarioId\" = usuario.\"ID\"");
        res.json(usuarios.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Conseguir ID del un grado
app.get("/gradoId/:numGrad", async(req, res)=>{
    const { numGrad } = req.params
    try{
        const grado = await pool.query("SELECT \"ID\" FROM grado WHERE clase = $1", [numGrad]);
        res.json(grado.rows)

    }catch(err) {
        console.error(err.message);

    }

});


//NO FUNCIONA
app.post("/nuevoCurso", async(req, res)=>{
    const { codigo } = req.params;
    const { nombre } = req.params;
    const { gradoId } = req.params;
    const { diaSemana } = req.params;
    const { horaInicio } = req.params;
    const { horaFin } = req.params;
    try{

        const newCurso = await pool.query("INSERT INTO curso(codigo, nombre, \"gradoId\", \"diaSemana\", \"horaInicio\", \"horaFin\") VALUES($1, $2, $3, $4, $5, $6) RETURNING *", [codigo, nombre, gradoId, diaSemana, horaInicio, horaFin]);
        res.json(newCurso.rows)

    }catch(err) {
        console.error(err.message);

    }

});

//Lista de todos los profesores
// app.get("/nuevoCurso", async(req, res)=>{
//     try{
//         const { cod } = req.params;
//         const { nom } = req.params;
//         const { grad } = req.params;
//         const { dia } = req.params;
//         const { horaIn } = req.params;
//         const { horaFin } = req.params;

//         const newCurso = await pool.query("SELECT * FROM insertarCurso($1, $2, $3, $4, $5, $6)", [cod,nom,grad,dia,horaIn,horaFin]);
//         res.json(newCurso.rows)

//     }catch(err) {
//         console.error(err.message);

//     }

// });

app.listen(PORT, HOST);
console.log('API running on port 8080')