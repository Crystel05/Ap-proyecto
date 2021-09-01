package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.admin_gc_modificar_curso.*

class admin_gc_modificarCurso : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_modificar_curso, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(
            activity!!, R.array.ListaGrados,
            R.layout.admin_gc_modificar_curso
        ).also {
            adapter -> adapter.setDropDownViewResource(R.layout.admin_gc_modificar_curso)
            gradoModificarCurso.adapter = adapter
        }
    }

}