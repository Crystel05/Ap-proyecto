package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_gd_modificar.*

class adminGdModificar : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_modificar, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        modificarDocente.setOnClickListener(){
            //guardar cambios
            Toast.makeText(activity!!, "El docente fue modificado con éxito", Toast.LENGTH_LONG).show()
            val lista = adminGdListaDocentes()
            cambiarFragment(lista)
        }
    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = activity!!.supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }

}