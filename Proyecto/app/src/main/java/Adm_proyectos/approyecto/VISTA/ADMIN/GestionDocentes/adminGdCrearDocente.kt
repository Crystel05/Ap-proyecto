package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_gd_crear_docente.*

class adminGdCrearDocente : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.admin_gd_crear_docente, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        agregarProfesorNuevoCrear.setOnClickListener(){
            cedulaCrearDocente.text.clear()
            nombreCrearDocente.text.clear()
            primerApellidoCrearDocente.text.clear()
            segundoApellidoCrearDocente.text.clear()
            correoCrearDocente.text.clear()
            Toast.makeText(activity!!, "El docente fue agregado con éxito", Toast.LENGTH_LONG).show()
        }

    }


}