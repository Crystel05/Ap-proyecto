package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos.adminAcDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos.adminAcListaCursos
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdListaDocentes
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.adminGeDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.adminGeListaEstudiantes
import Adm_proyectos.approyecto.VISTA.Chat2.MainActivity
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import Adm_proyectos.approyecto.VISTA.log_in
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main._admin_pricipal.*
import kotlinx.android.synthetic.main._log_in.*

class adminPricipal : AppCompatActivity(), Comunicador {

    val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._admin_pricipal)

        val listaCurso = admin_gc_listaCursos()
        controller.cambiarFragment(listaCurso, R.id.contenedor, this)
        //adminGC.background = Drawable.createFromPath("@drawable/button_selected.xml")

        adminGC.textSize = 20F

        adminGC.setOnClickListener{
            controller.cambiarFragment(listaCurso, R.id.contenedor, this)
            adminGC.textSize = 20F
            adminGD.textSize = 16F
            adminGE.textSize = 16F
            adminAC.textSize = 16F
        }

        adminGD.setOnClickListener{
            val listaDocentes = adminGdListaDocentes()
            controller.cambiarFragment(listaDocentes, R.id.contenedor, this)
            adminGC.textSize = 16F
            adminGD.textSize = 20F
            adminGE.textSize = 16F
            adminAC.textSize = 16F
        }

        adminGE.setOnClickListener{
            val listaEstudiantes = adminGeListaEstudiantes()
            controller.cambiarFragment(listaEstudiantes, R.id.contenedor, this)
            adminGC.textSize = 16F
            adminGD.textSize = 16F
            adminGE.textSize = 20F
            adminAC.textSize = 16F
        }

        adminAC.setOnClickListener{
            val cursos = adminAcListaCursos()
            controller.cambiarFragment(cursos, R.id.contenedor, this)
            adminGC.textSize = 16F
            adminGD.textSize = 16F
            adminGE.textSize = 16F
            adminAC.textSize = 20F
        }

        signOut.setOnClickListener{
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_LONG).show()
            Intent(this, log_in::class.java).also{
                startActivity(it)
            }
        }

        contenedor.setOnClickListener{view ->
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }

        val nombre = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombre"
    }

    override fun enviarDatosCurso(id: String, nombre:String) {
        val bundle = Bundle()
        bundle.putString("datosCurso", id)
        val datos = arrayOf(id, nombre)
        bundle.putStringArray("datosCurso", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = admin_gc_detalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()
    }

    override fun enviarDatosCursoAc(id: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosCursoAc", id)
        val datos = arrayOf(id, nombre)
        bundle.putStringArray("datosCursoAc", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminAcDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()
    }

    override fun enviarDatosDocente(ced: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosDocente", ced)

        val datos = arrayOf(ced, nombre)
        bundle.putStringArray("datosDocente", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminGdDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()

    }

    override fun enviarDatosDocente(est: Boolean) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosEstudiante", ced)

        val datos = arrayOf(ced, nombre, "1")
        bundle.putStringArray("datosEstudiante", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminGeDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()
    }

}

