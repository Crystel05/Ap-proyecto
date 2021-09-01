package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.popUpCursos
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*

class adminGeDetalles : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_detalles, container, false)

        val array = arguments?.getStringArray("datosEstudiante")
        val ced = array?.get(0)
        val nomD = array?.get(1)
        view.cedulaE.text = ced
        view.nombreE.text = nomD
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.verListaEstdiante.setOnClickListener(){
            popUp()
        }

        view.modificarEstudianteE.setOnClickListener(){
            val modificar = adminGeModificar()
            cambiarFragment(modificar)
        }

        view.eliminarEstudiante.setOnClickListener(){
            //eliminar
            Toast.makeText(activity!!, "El estudiante fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val lista = adminGeListaEstudiantes()
            cambiarFragment(lista)
        }
    }

    fun popUp(){
        val dialogo = popUpCursos()
        dialogo.show(activity!!.supportFragmentManager, "Prueba")
    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = activity!!.supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }

}