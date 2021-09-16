package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.popUpCursos
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*

class adminGeDetalles : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_detalles, container, false)

        val array = arguments?.getStringArray("datosEstudiante")
        val ced = array?.get(1)
        val nomD = array?.get(0)
        view.cedulaE.text = ced
        view.nombreE.text = nomD
        if (array?.get(2) == "1"){
            view.modificarEstudianteE.visibility = View.INVISIBLE
            view.eliminarEstudiante.visibility = View.INVISIBLE

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.verListaEstdiante.setOnClickListener(){
            popUp()
        }

        view.modificarEstudianteE.setOnClickListener(){
            val modificar = adminGeModificar()
            controller.cambiarFragment(modificar, R.id.contenedor, activity!!)
        }

        view.eliminarEstudiante.setOnClickListener(){
            //eliminar
            Toast.makeText(activity!!, "El estudiante fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val lista = adminGeListaEstudiantes()
            controller.cambiarFragment(lista, R.id.contenedor, activity!!)
        }
    }

    fun popUp(){
        val dialogo = popUpCursos()
        dialogo.show(activity!!.supportFragmentManager, "Cursos estudiante")
    }
}