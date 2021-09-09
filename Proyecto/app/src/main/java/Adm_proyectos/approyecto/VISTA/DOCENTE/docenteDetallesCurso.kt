package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteNoticias
import android.widget.Toast
import kotlinx.android.synthetic.main._estudiantes_principal.view.*
import kotlinx.android.synthetic.main.docente_detalles_curso.*

class docenteDetallesCurso : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.docente_detalles_curso, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noticia = estudianteNoticias()
        val array = arguments?.getStringArray("datosCursoEstudiante")
        val idCurso = array?.get(0)
        val nomCurso = array?.get(1)
        if(array?.get(2) == "2"){
            asignarNoticia.text = "VER NOTICIAS"
            enviarTarea.text = "VER TAREAS"
            verEstudiantes.text = "VER PROFESOR"

            asignarNoticia.setOnClickListener(){
                controller.cambiarFragment(noticia, view.contenedorEstudiante, activity!!)
            }

            chatGrupo.setOnClickListener(){
                Toast.makeText(activity!!, "Aun no", Toast.LENGTH_LONG).show();
            }

            enviarTarea.setOnClickListener(){
                controller.cambiarFragment(noticia, view.contenedorEstudiante, activity!!)
            }

            verEstudiantes.setOnClickListener(){
                val profesor = docentesListaEstudiantes() // cambiar por el nuevo
                controller.cambiarFragment(profesor, view.contenedorEstudiante, activity!!)
            }
        }

        else{
            asignarNoticia.setOnClickListener(){
                val noticia = docenteEnviarNoticia()
                controller.cambiarFragment(noticia, view.contenedorEstudiante, activity!!)
            }

            chatGrupo.setOnClickListener(){
                Toast.makeText(activity!!, "Aun no", Toast.LENGTH_LONG).show();
            }

            enviarTarea.setOnClickListener(){
                val tarea = docentesAsignarTarea()
                controller.cambiarFragment(tarea, view.contenedorEstudiante, activity!!)
            }

            verEstudiantes.setOnClickListener(){
                val estudiantes = docentesListaEstudiantes()
                controller.cambiarFragment(estudiantes, view.contenedorEstudiante, activity!!)
            }
        }
    }
}