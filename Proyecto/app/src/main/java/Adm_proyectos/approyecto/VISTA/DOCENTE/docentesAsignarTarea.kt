package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.docetes_asignar_tarea.view.*

class docentesAsignarTarea : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.docetes_asignar_tarea, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.asignarTarea.setOnClickListener(){
            //comprobar que estén todos los datos
            val detalles = docenteDetallesCurso()
            controller.cambiarFragment(detalles, R.id.contenedorDocente, activity!!)
            Toast.makeText(activity!!, "Tarea asignada con éxito", Toast.LENGTH_LONG).show()
        }
    }

}