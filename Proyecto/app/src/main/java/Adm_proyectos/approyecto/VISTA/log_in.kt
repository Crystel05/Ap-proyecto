package Adm_proyectos.approyecto.VISTA

import Adm_proyectos.approyecto.CONTROLADOR.controladorLogIn
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN.adminPricipal
import Adm_proyectos.approyecto.VISTA.DOCENTE.docentePrincipal
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudiantesPrincipal
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main._log_in.*
import kotlinx.android.synthetic.main._log_in.view.*

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

            val respuesta = controlller.escogerUsuario(correo, contrasenna)
            if (respuesta == 1){
                Intent(this, admin::class.java).also{
                    it.putExtra("CORREO", correo)
                    it.putExtra("CONTRASENNA", contrasenna)
                    startActivity(it)
                }
            }
            else if (respuesta == 2){
                Intent(this, docentePrincipal::class.java).also{
                    it.putExtra("CORREO", correo)
                    it.putExtra("CONTRASENNA", contrasenna)
                    startActivity(it)
                }
            }
            else if(respuesta == 3){
                Intent(this, estudiantesPrincipal::class.java).also{
                    it.putExtra("CORREO", correo)
                    it.putExtra("CONTRASENNA", contrasenna)
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

    }
}