package Adm_proyectos.approyecto.VISTA.INTERFACES

interface DatosAdmin {

    fun enviarDatosCurso (id: String, nombre: String, grado:String, horario:String)
    fun enviarDatosCurso2 (id: String, nombre: String, grado:String, horario:String)
    fun enviarDatosCurso (id: String, nombre: String)
    fun enviarDatosCursoAc (id: String, nombre: String)
    fun enviarDatosDocente(ced: String, nombre:String)
    fun enviarDatosDocente(ced: String, nombre:String, correo: String, calificacion: String)
    fun enviarDatosDocente(ced: String, nombre:String, correo: String)
    fun enviarDatosDocente(est: Boolean)
    fun enviarDatosEstudiante(ced: String, nombre: String)
    fun enviarDatosEstudiante(ced: String, nombre: String, grado:String)

}