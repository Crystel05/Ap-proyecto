package Adm_proyectos.approyecto.MODELO

class Estudiante(nombre: String, apellidos: String, correo: String, cedula: String, contrasenna: String, gradoEscolar: Int, listaCursos: ArrayList<Curso>) :
    Usuario (nombre, apellidos, correo, cedula, contrasenna){

    var gradoEscolar: Int
    val listaCursos: ArrayList<Curso>

    init {
        this.gradoEscolar = gradoEscolar
        this.listaCursos = listaCursos
    }
}