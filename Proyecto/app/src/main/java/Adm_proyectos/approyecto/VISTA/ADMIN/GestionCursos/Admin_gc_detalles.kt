package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador2
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gc_detalles.*
import kotlinx.android.synthetic.main.admin_gc_detalles.view.*

class admin_gc_detalles : Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var comunicador: Comunicador2
    private lateinit var comunicador2: Comunicador
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_detalles, container, false)
        comunicador = activity as Comunicador2
        comunicador2 = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
        val array = arguments?.getStringArray("datosCursoNuevo")
        val idCursoS = " " + array?.get(0)
        val nombreCurso = array?.get(1).toString()
        val grado = array?.get(2).toString()
        val horario = array?.get(3).toString()
        view.idCurso.text = idCursoS
        view.nombreCurso.text = nombreCurso
        view.gradoCurso.text = grado
        view.horarioCurso.text = horario

        view.modificarCurso.setOnClickListener(){
            comunicador2.enviarDatosCurso2(idCursoS, nombreCurso, grado, horario)
        }

        eliminarCurso.setOnClickListener(){
            Toast.makeText(activity!!, "El curso fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val listaCursos = admin_gc_listaCursos()
            controller.cambiarFragment(listaCursos, R.id.contenedor, activity!!)
        }
    }

}