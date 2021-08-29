package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R

class adminGdCrearDocente : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.admin_gd_crear_docente, container, false)

        return view
    }

}