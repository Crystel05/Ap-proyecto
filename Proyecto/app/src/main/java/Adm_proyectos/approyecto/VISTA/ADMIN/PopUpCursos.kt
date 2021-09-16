package Adm_proyectos.approyecto.VISTA.ADMIN

import Adm_proyectos.approyecto.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class popUpCursos: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pop_up_lista_cursos, container, false)
        return view
    }
}