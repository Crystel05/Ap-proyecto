package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import kotlinx.android.synthetic.main.admin_ac_detalles.view.*
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*

class adminAcDetalles : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_detalles, container, false)
        val array = arguments?.getStringArray("datosCursoAc")
        val id = array?.get(0)
        val nomAc = array?.get(1)
        view.idCursoAc.text = id
        view.nombreCursoAc.text = nomAc

        view.asignarProfesor.setOnClickListener(){
            val listaProfes = adminAcListaDocentes()
            cambiarFragment(listaProfes)
        }

        view.agregarEstudiantes.setOnClickListener(){
            val listaEstudiantes = adminAcListaEstudiantes()
            cambiarFragment(listaEstudiantes)
        }

        return view
    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = activity!!.supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }

}