package Adm_proyectos.approyecto.VISTA

import API.RetroInstance
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN.adminPricipal
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.popUpCursos
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import kotlinx.android.synthetic.main._log_in.*
import kotlinx.android.synthetic.main._log_in.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
            val intent = Intent(this, admin::class.java)
            startActivity(intent)
        }

    }
}