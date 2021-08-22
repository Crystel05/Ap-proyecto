package Adm_proyectos.approyecto.MODELO

class Profesor (nombre: String, apellidos: String, correo: String, cedula: Int, contrasenna: String,
                calificaciones: ArrayList<Int>, listaCursos: ArrayList<Curso>) :
                Usuario(nombre, apellidos, correo, cedula, contrasenna){

    var calificaciones : ArrayList<Int>
    var listaCursos : ArrayList<Curso>

    init {
        this.calificaciones = calificaciones
        this.listaCursos = listaCursos
    }

}