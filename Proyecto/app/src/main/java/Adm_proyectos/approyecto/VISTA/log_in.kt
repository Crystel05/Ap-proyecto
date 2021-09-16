package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.CONTROLADOR.controladorLogIn
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN.adminPricipal
import Adm_proyectos.approyecto.VISTA.CHAT.Chat
import Adm_proyectos.approyecto.VISTA.Chat2.MainActivity
import Adm_proyectos.approyecto.VISTA.DOCENTE.docentePrincipal
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudiantesPrincipal
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main._log_in.*
import kotlinx.android.synthetic.main._log_in.view.*
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class log_in : AppCompatActivity() {

    val controlller = controladorLogIn()

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
            val docentePrincipal = docentePrincipal()
            val correo = correoInicioSesion.text.toString()
            val contrasenna = contrasenna.text.toString()
            //if usuario admin

            controlller.escogerUsuario(this, correo, contrasenna, tipoUsuario)
            if (!tipoUsuario.text.equals("x")) {
                Toast.makeText(this, tipoUsuario.text.toString(), Toast.LENGTH_SHORT).show()
//                val datos = tipoUsuario.text.split("_")
//                val nombre = datos[0]
//                val tipo = datos[1]
//
//    //            Toast.makeText(this, respuesta.toString(), Toast.LENGTH_SHORT).show()
//                if (tipo.equals("administrador")){
//                    Intent(this, admin::class.java).also{
//                        it.putExtra("nombre", nombre)
//                        startActivity(it)
//                    }
//                }
//                else if (tipo.equals("profesor")){
//                    Intent(this, docentePrincipal::class.java).also{
//                        it.putExtra("nombre", nombre)
//                        startActivity(it)
//                    }
//                }
//                else if(tipo.equals("estudiante")){
//                    Intent(this, estudiantesPrincipal::class.java).also{
//                        it.putExtra("nombre", nombre)
//                        startActivity(it)
//                    }
//                }
            }
            else{
//                Intent(this, MainActivity::class.java).also{
////                    it.putExtra("CORREO", correo)
////                    it.putExtra("CONTRASENNA", contrasenna)
//                    startActivity(it)
//                }
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

//        login.setOnClickListener{view ->
//            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
//        }

    }
}