package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.databinding.AdminGcPrincipalBinding
import Adm_proyectos.approyecto.databinding.AdminPrincipalBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class admin_principal : Fragment() {

    private var _binding: AdminPrincipalBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdminPrincipalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.agregarCurso.setOnClickListener(){
            irAventanaCrearCurso()
        }



    }

    fun irAventanaCrearCurso(){
        binding.adminGcPrincipal.visibility = View.INVISIBLE
        binding.adminGcCrear.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}