package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.popUpCursos
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteCalificarDocente
import android.widget.Toast
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gd_detalles.*
import kotlinx.android.synthetic.main.admin_gd_detalles.view.*

class adminGdDetalles : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_detalles, container, false)
        val array = arguments?.getStringArray("datosDocente")
        val ced = array?.get(0)
        val nomD = array?.get(1)
        view.cedulaD.text = ced
        view.nombreD.text = nomD
        view.ratingD.rating = 2.5F
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val esEst = arguments?.getBoolean("datosDocente")

        view.verListaDocente.setOnClickListener(){
            popUp()
        }

        view.modificarDocenteP.setOnClickListener(){
            val modificar = adminGdModificar()
            controller.cambiarFragment(modificar, R.id.contenedor, activity!!)
        }
        eliminarDocente.setOnClickListener(){
            Toast.makeText(activity!!, "El docente fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val listaDocentes = adminGdListaDocentes()
            controller.cambiarFragment(listaDocentes, R.id.contenedor, activity!!)
        }

        if(esEst == true){
            eliminarDocente.visibility = View.INVISIBLE
            modificarDocenteP.visibility = View.INVISIBLE
            listCursos.visibility = View.INVISIBLE
            verListaDocente.visibility = View.INVISIBLE
            calificarProfesor.visibility = View.VISIBLE
        }
        calificarProfesor.setOnClickListener(){
            popUp2()
        }

    }

    fun popUp(){
        val dialogo = popUpCursos()
        dialogo.show(activity!!.supportFragmentManager, "Prueba")
    }

    fun popUp2(){
        val dialogo = estudianteCalificarDocente()
        dialogo.show(activity!!.supportFragmentManager, "Prueba")
    }
}