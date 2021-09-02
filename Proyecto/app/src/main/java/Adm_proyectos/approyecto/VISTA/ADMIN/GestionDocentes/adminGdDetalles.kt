package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.popUpCursos
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_gd_detalles.*
import kotlinx.android.synthetic.main.admin_gd_detalles.view.*

class adminGdDetalles : Fragment() {

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

        view.verListaDocente.setOnClickListener(){
            popUp()
        }

        view.modificarDocenteP.setOnClickListener(){
            val modificar = adminGdModificar()
            cambiarFragment(modificar)
        }
        eliminarDocente.setOnClickListener(){
            Toast.makeText(activity!!, "El docente fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val listaDocentes = adminGdListaDocentes()
            cambiarFragment(listaDocentes)
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