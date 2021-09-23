package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.DOCENTE.DocenteListaCursos
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
import kotlinx.android.synthetic.main._admin_pricipal.nombreUsuario
import kotlinx.android.synthetic.main._docente_principal.*
import kotlinx.android.synthetic.main._estudiantes_principal.*


class estudiantesPrincipal : AppCompatActivity(), DatosDocente {

    private val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._estudiantes_principal)

        val nombreUsu = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombreUsu"
        val correo = intent.getStringExtra("correo")
        val cedula = intent.getStringExtra("cedula").toString()
        val apellido = intent.getStringExtra("apellido").toString().replace("\"", "")

        irPrimeraPantalla(correo.toString(), nombreUsu.toString(), apellido, cedula)

        val nombre = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombre"

        contenedorEstudiante.setOnClickListener{view ->
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }

        salirSesionEst.setOnClickListener {
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_LONG).show()
            Intent(this, log_in::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun irPrimeraPantalla(correo: String, nombre: String, apellido: String, cedula:String){

        val Lista = DocenteListaCursos()
        val bundle = Bundle()
        val datos = arrayOf(correo, nombre, apellido, cedula)
        bundle.putStringArray("datosEst", datos)
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        Lista.arguments = bundle
        transaction.add(R.id.contenedorEstudiante, Lista, null)
        transaction.commit()

    }

    override fun enviarDatosEstudiante(
        ced: String,
        nombre: String,
        grado: String,
        curso: String,
        correoProfe: String,
        correo: String
    ) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(id: String, grado: String, correo: String, fragment: Fragment) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(
        id: String,
        nombre: String,
        grado: String,
        horario: String,
        fragment: Fragment,
        correo: String,
        nombreP: String,
        apellido: String
    ) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(
        id: String,
        grado: String,
        fragment: Fragment,
        correo: String,
        nombreP: String,
        apellido: String
    ) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(
        id: String,
        nombre: String,
        grado: String,
        horario: String,
        fragment: Fragment,
        correo: String
    ) {
        TODO("Not yet implemented")
    }

    override fun enviarCorreo(correo: String, fragment: Fragment) {
        TODO("Not yet implemented")
    }

    override fun cursosPopUp(cursos: ArrayList<String>) {
        TODO("Not yet implemented")
    }

//    override fun enviarDatosCurso(id: String, nombre: String, grado: String, horario: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosCurso(id: String, nombre: String) {
//        val bundle = Bundle()
//        bundle.putString("datosCursoEstudiante", id)
//        val datos = arrayOf(id, nombre, "2")
//        bundle.putStringArray("datosCursoEstudiante", datos)
//
//        val transaccion = this.supportFragmentManager.beginTransaction()
//        val detalles = docenteDetallesCurso()
//        detalles.arguments = bundle
//
//        transaccion.replace(R.id.contenedorEstudiante, detalles)
//        transaccion.commit()
//    }
//
//    override fun enviarDatosCurso2(id: String, nombre: String, grado: String, horario: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosCursoAc(id: String, nombre: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosDocente(ced: String, nombre: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosDocente(
//        ced: String,
//        nombre: String,
//        correo: String,
//        calificacion: String
//    ) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosDocente(ced: String, nombre: String, correo: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosDocente(estudiante: Boolean) {
//        val bundle = Bundle()
//        bundle.putBoolean("datosDocente", estudiante)
//
//        val transaccion = this.supportFragmentManager.beginTransaction()
//        val detalles = AdminGdDetalles()
//        detalles.arguments = bundle
//
//        transaccion.replace(R.id.contenedorEstudiante, detalles)
//        transaccion.commit()
//    }
//
//    override fun enviarDatosEstudiante(ced: String, nombre: String) {
//        TODO("Not yet implemented")
//    }
//
//    override fun enviarDatosEstudiante(ced: String, nombre: String, grado: String) {
//        TODO("Not yet implemented")
//    }
}