package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.AdminGdDetalles
import Adm_proyectos.approyecto.VISTA.DOCENTE.DocenteDetallesCurso
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosDocente
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosEstudiante
import Adm_proyectos.approyecto.VISTA.log_in
import DocenteListaCursos
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main._estudiantes_principal.*


class estudiantesPrincipal : AppCompatActivity(), DatosEstudiante, DatosDocente {

    private val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._estudiantes_principal)

        val nombre = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombre"
        val correo = intent.getStringExtra("correo")


        salirSesion.setOnClickListener{
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_LONG).show()
            Intent(this, log_in::class.java).also{
                startActivity(it)
            }
        }

        contenedorEstudiante.setOnClickListener{view ->
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }

        irPrimeraPantalla(correo.toString())
    }

    private fun irPrimeraPantalla(correo: String) {
        val Lista = DocenteListaCursos()
        val bundle = Bundle()
        bundle.putString("correo",correo)
        Lista.arguments = bundle

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.contenedorDocente, Lista, null)
        transaction.commit()
    }

    override fun enviarDatosCurso(id: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosCursoEstudiante", id)
        bundle.putString("esEstudiante", "1")
        val datos = arrayOf(id, nombre, "2")
        bundle.putStringArray("datosCursoEstudiante", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = DocenteDetallesCurso()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorEstudiante, detalles)
        transaccion.commit()
    }

    override fun enviarDatosDocente(estudiante: Boolean) {
        val bundle = Bundle()
        bundle.putBoolean("datosDocente", estudiante)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = AdminGdDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorEstudiante, detalles)
        transaccion.commit()
    }

    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(id: String, grado: String, correo: String, fragment: Fragment) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(id: String, nombre: String, grado: String, horario: String, fragment: Fragment, correo: String) {
        TODO("Not yet implemented")
    }

    override fun enviarCorreo(correo: String, fragment: Fragment) {
        TODO("Not yet implemented")
    }

}