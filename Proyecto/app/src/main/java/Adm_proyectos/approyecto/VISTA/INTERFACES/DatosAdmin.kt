package Adm_proyectos.approyecto.VISTA.INTERFACES

import androidx.fragment.app.Fragment

interface DatosAdmin {

    fun enviarDatosCurso (id: String, nombre: String, grado:String, horario:String, fragment: Fragment)
//    fun enviarDatosCurso2 (id: String, nombre: String, grado:String, horario:String)
//    fun enviarDatosCurso (id: String, nombre: String)
//    fun enviarDatosCursoAc (id: String, nombre: String)
//    fun enviarDatosDocente(ced: String, nombre:String)
    fun enviarDatosDocente(ced: String, nombre:String, correo: String, calificacion: String, contra:String, fragment: Fragment)
//    fun enviarDatosDocente(ced: String, nombre:String, correo: String, contra:String)
//    fun enviarDatosDocente(est: Boolean)
//    fun enviarDatosEstudiante(ced: String, nombre: String)
//    fun enviarDatosEstudiante(ced: String, nombre: String, grado:String)

//    fun enviarId(id:String)
    fun cursosDocente(cursos:ArrayList<String>)
}