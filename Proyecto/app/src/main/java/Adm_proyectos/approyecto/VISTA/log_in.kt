package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN.adminPricipal
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import kotlinx.android.synthetic.main._log_in.*
import kotlinx.android.synthetic.main._log_in.view.*

class log_in : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._log_in)
        show.setOnClickListener() {
            notshow.visibility = View.VISIBLE
            show.visibility = View.INVISIBLE
            contrasenna.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        notshow.setOnClickListener() {
            show.show.visibility = View.VISIBLE
            notshow.visibility = View.INVISIBLE
            contrasenna.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }

        iniciarSesion.setOnClickListener() {
            val admin = adminPricipal()
            val correo = correoInicioSesion.text.toString()
            val contrasenna = contrasenna.text.toString()
            //if usuario admin
            Intent(this, admin::class.java).also{
                it.putExtra("CORREO", correo)
                it.putExtra("CONTRASENNA", contrasenna)
                startActivity(it)
            }
            //if usuario docente
            //if usuario estudiante
        }

    }
}