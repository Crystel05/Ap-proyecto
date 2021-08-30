package Adm_proyectos.approyecto.VISTA.INTERFACES

interface Comunicador {
    fun enviarDatosCurso (id: String, nombre: String)
    fun enviarDatosCursoAc (id: String, nombre: String)
    fun enviarDatosDocente(ced: String, nombre:String)
    fun enviarDatosEstudiante(ced: String, nombre: String)
}