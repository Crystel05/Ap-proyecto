package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.databinding.LoginBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class main : AppCompatActivity()  {

//    private lateinit var binding: AdminPrincipalBinding
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)
//        binding = AdminPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}