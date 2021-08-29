package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import kotlinx.android.synthetic.main.admin_gc_detalles.view.*

class admin_gc_detalles : Fragment() {

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
            cambiarFragment(modificar)
        }
    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = activity!!.supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }

}