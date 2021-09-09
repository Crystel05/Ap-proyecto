package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_gc_crear.*
import kotlinx.android.synthetic.main.admin_gc_crear.view.*

class admin_gc_crear : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_crear, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter.createFromResource(
            context!!,
            R.array.ListaGrados,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.gradoCrearCurso.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            context!!,
            R.array.diasSemana,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.diaCrearCurso.adapter = adapter
        }

        agregarCursoGC.setOnClickListener() {
            //agregar curso
            //if todo bien
            idCrearCurso.text.clear()
            nombreCrearCurso.text.clear()
            horaInicioCrearCurso.text.clear()
            horafinCrearCurso.text.clear()
            Toast.makeText(activity!!, "El curso fue agregado con éxito", Toast.LENGTH_LONG).show()
            //else toast
        }

    }



}