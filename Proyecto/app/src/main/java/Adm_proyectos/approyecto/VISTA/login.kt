package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.databinding.LoginBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class login : Fragment() {

    private var _binding: LoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iniciarSesion.setOnClickListener() { iniciarSesion() }

        binding.notshow.setOnClickListener() { mostrarContrasenna() }

        binding.show.setOnClickListener() { esconderContrasenna() }
    }

    fun mostrarContrasenna() {
        binding.show.visibility = View.VISIBLE
        binding.notshow.visibility = View.INVISIBLE
        binding.contrasenna.transformationMethod = HideReturnsTransformationMethod.getInstance()

    }

    fun esconderContrasenna() {
        binding.notshow.visibility = View.VISIBLE
        binding.show.visibility = View.INVISIBLE
        binding.contrasenna.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    fun iniciarSesion (){
        findNavController().navigate(R.id.login_admin)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


