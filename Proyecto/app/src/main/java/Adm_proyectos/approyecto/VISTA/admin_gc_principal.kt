package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.databinding.AdminGcPrincipalBinding
import Adm_proyectos.approyecto.databinding.AdminPrincipalBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class admin_gc_principal: Fragment() {

    private var _binding: AdminGcPrincipalBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdminGcPrincipalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.agregarCurso.setOnClickListener(){}
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}