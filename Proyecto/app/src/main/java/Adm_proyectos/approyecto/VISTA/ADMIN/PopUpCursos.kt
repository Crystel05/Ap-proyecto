package Adm_proyectos.approyecto.VISTA.ADMIN

import Adm_proyectos.approyecto.R
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class popUpCursos: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pop_up_lista_cursos, container, false)
        return view
    }
}