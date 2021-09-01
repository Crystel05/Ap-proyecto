package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class docentesListaEstudiantes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.docentes_lista_estudiantes, container, false)
    }

}