package Adm_proyectos.approyecto.VISTA.INTERFACES

import androidx.fragment.app.Fragment

interface DatosEstudiante {
    fun enviarDatosCurso (id: String, grado:String)
    fun enviarDatosDocente(estudiante:Boolean)
}