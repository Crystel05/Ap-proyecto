package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.databinding.AdminGcCrearBinding
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class admin_gc_crear : Fragment(){

    private var _binding: AdminGcCrearBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdminGcCrearBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter.createFromResource(
            context!!,
            R.array.ListaGrados,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.grados.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            context!!,
            R.array.diasSemana,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.dias.adapter = adapter
        }

        binding.agregarCursoGC.setOnClickListener(){
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}