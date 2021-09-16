package Adm_proyectos.approyecto.VISTA.DOCENTE

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import androidx.fragment.app.Fragment

class docenteDetallesEstudiante : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.docente_detalles_estudiante, container, false)
        return view
    }

}