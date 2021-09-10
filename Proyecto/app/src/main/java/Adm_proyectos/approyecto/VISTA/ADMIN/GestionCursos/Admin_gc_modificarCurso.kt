package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gc_modificar_curso.*

class admin_gc_modificarCurso : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_modificar_curso, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(activity!!, R.array.ListaGrados, R.layout.support_simple_spinner_dropdown_item).also {
            adapter -> adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            gradoModificarCurso.adapter = adapter
        }
        ArrayAdapter.createFromResource(activity!!, R.array.diasSemana, R.layout.support_simple_spinner_dropdown_item).also {
         adapter -> adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
         diaModificarCurso.adapter = adapter
        }
        guardarCursoGCM.setOnClickListener(){
            //guardar cambios
            Toast.makeText(activity!!, "El curso fue guardado con éxito", Toast.LENGTH_LONG).show()
            val listaCursos = admin_gc_listaCursos()
            controller.cambiarFragment(listaCursos, R.id.contenedor, activity!!)
        }
    }
}