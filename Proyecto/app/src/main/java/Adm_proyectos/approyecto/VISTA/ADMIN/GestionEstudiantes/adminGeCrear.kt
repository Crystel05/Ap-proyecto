package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.admin_ge_crear.*

class adminGeCrear : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_crear, container, false)
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
            gradosGeA.adapter = adapter
        }

        agregarEstudiante.setOnClickListener(){
            Toast.makeText(activity!!, "Estudiante agregado con éxito", Toast.LENGTH_LONG).show()
            val lista = adminGeListaEstudiantes()
            cambiarFragment(lista)
        }

    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }

}