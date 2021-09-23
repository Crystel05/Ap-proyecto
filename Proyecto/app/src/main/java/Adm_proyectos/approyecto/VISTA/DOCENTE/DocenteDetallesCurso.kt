package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.CHAT.Chat
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteNoticias
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosDocente
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_modificar.*
import kotlinx.android.synthetic.main.docente_detalles_curso.*

class DocenteDetallesCurso : Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var comunicador: DatosDocente
    private lateinit var grado: String
    private lateinit var idCurso: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        comunicador = activity as DatosDocente
        val view = inflater.inflate(R.layout.docente_detalles_curso, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val noticia = estudianteNoticias()
        val array = arguments?.getStringArray("datosCurso")
        llenarDatos(array)
        val correo = array?.get(4).toString()
        if(array?.get(5) == "2"){
            asignarNoticia.text = "VER NOTICIAS"
            enviarTarea.text = "VER TAREAS"
            verEstudiantes.text = "VER PROFESOR"

            asignarNoticia.setOnClickListener(){
                controller.cambiarFragment(noticia, R.id.contenedorEstudiante, activity!!)
            }

            chatGrupo.setOnClickListener(){
                Toast.makeText(activity!!, "Aun no", Toast.LENGTH_LONG).show();
            }

            enviarTarea.setOnClickListener(){
                controller.cambiarFragment(noticia, R.id.contenedorEstudiante, activity!!)
            }

            verEstudiantes.setOnClickListener(){
//                val profesor = adminGdDetalles() // cambiar por el nuevo
//                controller.cambiarFragment(profesor, R.id.contenedorEstudiante, activity!!)
//                comunicador.enviarDatosDocente(true)
            }
        }
        else{
            asignarNoticia.setOnClickListener{
                val noticia = DocenteEnviarNoticia()
                comunicador.enviarDatosCurso(idCurso, grado, correo, noticia)
            }

            chatGrupo.setOnClickListener{
                val chat = Chat()
                controller.cambiarFragment(chat, R.id.contenedorDocente, activity!!)
            }

            enviarTarea.setOnClickListener(){
                val tarea = DocentesAsignarTarea()
                comunicador.enviarDatosCurso(idCurso, grado, correo, tarea)
            }

            verEstudiantes.setOnClickListener{
                val estudiantes = docentesListaEstudiantes()
                comunicador.enviarDatosCurso(idCurso, grado, correo, estudiantes)
            }
        }


        volverDetalles.setOnClickListener{
            val listaCursos = DocenteListaCursos()
            comunicador.enviarCorreo(correo, listaCursos)
            controller.cambiarFragment(listaCursos, R.id.contenedorDocente, activity!!)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun llenarDatos(array: Array<String>?) {
        idCurso = array?.get(0).toString()
        val nomCurso = array?.get(1).toString()
        grado = array?.get(2).toString()
        val horario = array?.get(3)

        idCursoDocentes.text = " $idCurso"
        nombreCursoDocente.text = nomCurso
        gradoCursoDocente.text = grado
        horarioCursoDocente.text = horario
    }
}