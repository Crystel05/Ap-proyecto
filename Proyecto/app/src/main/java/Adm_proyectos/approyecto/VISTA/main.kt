package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.databinding.LoginBinding
import Adm_proyectos.approyecto.databinding.MainBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class main : AppCompatActivity()  {

    private lateinit var binding: MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}