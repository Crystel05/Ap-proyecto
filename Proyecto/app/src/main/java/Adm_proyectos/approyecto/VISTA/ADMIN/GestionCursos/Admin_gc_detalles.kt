package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gc_detalles.*
import kotlinx.android.synthetic.main.admin_gc_detalles.view.*

class admin_gc_detalles : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.admin_gc_detalles, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
        val array = arguments?.getStringArray("datosCurso")
        val idCursoS = " " + array?.get(0)
        val nombreCurso = array?.get(1)
        view.idCurso.text = idCursoS
        view.nombreCurso.text = nombreCurso

        view.modificarCurso.setOnClickListener(){
            val modificar = admin_gc_modificarCurso()
            controller.cambiarFragment(modificar, view.contenedor, activity!!)
        }

        eliminarCurso.setOnClickListener(){
            Toast.makeText(activity!!, "El curso fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val listaCursos = admin_gc_listaCursos()
            controller.cambiarFragment(listaCursos, view.contenedor, activity!!)
        }
    }

}