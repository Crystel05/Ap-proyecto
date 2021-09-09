package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.support.v4.app.DialogFragment

class estudianteCalificarDocente : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pop_up_estudiante_calificar_docente, container, false)
        return view
    }

}