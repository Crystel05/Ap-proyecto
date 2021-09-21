package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.AdminGeDetalles
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosDocente
import Adm_proyectos.approyecto.VISTA.log_in
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main._admin_pricipal.*
import kotlinx.android.synthetic.main._docente_principal.*
import kotlinx.android.synthetic.main._docente_principal.nombreUsuario

class DocentePrincipal : AppCompatActivity(), DatosDocente {

    private val controller = ControladorComponentesVista()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._docente_principal)

        val nombreUsu = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombreUsu"
        val correo = intent.getStringExtra("correo")

        irPrimeraPantalla(correo.toString())
        salir.setOnClickListener{
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_LONG).show()
            Intent(this, log_in::class.java).also{
                startActivity(it)
            }
        }
        contenedorDocente.setOnClickListener{view ->
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }

    private fun irPrimeraPantalla(correo: String){
        val Lista = DocenteListaCursos()
        val bundle = Bundle()
        bundle.putString("correo",correo)
        Lista.arguments = bundle

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.contenedorDocente, Lista, null)
        transaction.commit()
    }

    override fun enviarDatosCurso(id: String, grado: String, correo: String, fragment: Fragment) {
        val bundle = Bundle()
        val datos = arrayOf(id,grado,correo)
        bundle.putStringArray("datosCursoPequeno", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        fragment.arguments = bundle

        transaccion.replace(R.id.contenedorDocente, fragment)
        transaccion.commit()
    }

    override fun enviarDatosCurso(id: String, nombre: String, grado: String, horario: String, fragment: Fragment, correo: String) {
        val bundle = Bundle()
        val datos = arrayOf(id, nombre, grado, horario, correo, "1")
        bundle.putStringArray("datosCurso", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = DocenteDetallesCurso()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorDocente, detalles)
        transaccion.commit()
    }

    override fun enviarCorreo(correo: String, fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString("correoProfesor", correo)
        fragment.arguments = bundle
    }



    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        val bundle = Bundle()
        val datos = arrayOf(ced, nombre, "1")
        bundle.putStringArray("datosEstudiante", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = AdminGeDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorDocente, detalles)
        transaccion.commit()
    }
}