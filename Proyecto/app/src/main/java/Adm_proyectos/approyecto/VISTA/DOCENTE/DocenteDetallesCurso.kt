package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.CHAT.Chat
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteNoticias
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteTareas
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosDocente
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosEstudiante
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_crear.*
import kotlinx.android.synthetic.main.admin_ge_modificar.*
import kotlinx.android.synthetic.main.docente_detalles_curso.*

class DocenteDetallesCurso : Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var comunicador: DatosDocente
    private lateinit var comunicador2: DatosEstudiante
    private lateinit var grado: String
    private lateinit var idCurso: String
    private lateinit var nombreP: String
    private lateinit var apellidoP: String
    private lateinit var cedula: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        comunicador = activity as DatosDocente
        comunicador2 = activity as DatosEstudiante
        val view = inflater.inflate(R.layout.docente_detalles_curso, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val array = arguments?.getStringArray("datosCursoGrande")
        controller.notificacion(array.toString(), activity!!)
        val array2 = arguments?.getStringArray("datosCurso")
        var usar = array
        var grande = true
        var correo = array?.get(4).toString()
        var cambio = ""
        var cor = ""
        if (array?.size == 9){
            cambio = usar?.get(8).toString()
            cor = array?.get(7).toString()
        }

        if(array?.get(0) == null) {
            usar = array2
            cambio = array2?.get(5).toString()
            grande = false
            correo = array2?.get(4).toString()
        }
        llenarDatos(usar, grande)
        if(cambio == "2"){
            asignarNoticia.text = "VER NOTICIAS"
            enviarTarea.text = "VER TAREAS"
            verEstudiantes.text = "VER PROFESOR"

            val noticia = estudianteNoticias()

            asignarNoticia.setOnClickListener{
                comunicador.enviarDatosCurso(idCurso, grado, correo, noticia, nombreP, apellidoP)
            }

            chatGrupo.setOnClickListener{
                val chat = Chat()
                comunicador.enviarDatosCurso(idCurso, grado, chat, cor, nombreP, apellidoP)
            }

            enviarTarea.setOnClickListener{
                val tarea = estudianteTareas()
                comunicador.enviarDatosCurso(idCurso, grado, correo, tarea)
            }

            verEstudiantes.setOnClickListener{
//                val profesor = adminGdDetalles() // cambiar por el nuevo
//                controller.cambiarFragment(profesor, R.id.contenedorEstudiante, activity!!)
//                comunicador.enviarDatosDocente(true)
            }

            volverDetalles.setOnClickListener {
                val listaCursos = DocenteListaCursos()
                comunicador.enviarCorreo(correo, listaCursos)
                controller.cambiarFragment(listaCursos, R.id.contenedorEstudiante, activity!!)
            }
        }
        else{
            asignarNoticia.setOnClickListener{
                val noticia = DocenteEnviarNoticia()
                comunicador.enviarDatosCurso(idCurso, grado, correo, noticia, nombreP, apellidoP)
            }

            chatGrupo.setOnClickListener{
                val chat = Chat()
                comunicador.enviarDatosCurso(idCurso, grado, chat, correo, nombreP, apellidoP)
            }

            enviarTarea.setOnClickListener(){
                val tarea = DocentesAsignarTarea()
                comunicador.enviarDatosCurso(idCurso, grado, correo, tarea, nombreP, apellidoP)
            }

            verEstudiantes.setOnClickListener{
                val estudiantes = docentesListaEstudiantes()
                comunicador.enviarDatosCurso(idCurso, grado, correo, estudiantes, nombreP, apellidoP)
            }

            volverDetalles.setOnClickListener{
                val listaCursos = DocenteListaCursos()
                comunicador.enviarCorreo(correo, listaCursos)
                controller.cambiarFragment(listaCursos, R.id.contenedorDocente, activity!!)
            }
        }


    }

    @SuppressLint("SetTextI18n")
    private fun llenarDatos(array: Array<String>?, grande:Boolean) {
        idCurso = array?.get(0).toString()
        val nomCurso = array?.get(1).toString()
        grado = array?.get(2).toString()
        val horario = array?.get(3)

        if (grande) {
            nombreP = array?.get(5).toString()
            apellidoP = array?.get(6).toString()

        }
        idCursoDocentes.text = " $idCurso"
        nombreCursoDocente.text = nomCurso
        gradoCursoDocente.text = grado
        horarioCursoDocente.text = horario
    }
}