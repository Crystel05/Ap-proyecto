package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdDetalles
import Adm_proyectos.approyecto.VISTA.DOCENTE.docenteDetallesCurso
import Adm_proyectos.approyecto.VISTA.DOCENTE.docenteListaCursos
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main._admin_pricipal.*


class estudiantesPrincipal : AppCompatActivity(), Comunicador {

    private val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._estudiantes_principal)
        val listaCursos = docenteListaCursos()
        controller.cambiarFragment(listaCursos, R.id.contenedorEstudiante, this)

        val nombre = intent.getStringExtra("nombre")
        nombreUsuario.text = "$nombre"
    }

    override fun enviarDatosCurso(id: String, nombre: String, grado: String, horario: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCurso(id: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosCursoEstudiante", id)
        val datos = arrayOf(id, nombre, "2")
        bundle.putStringArray("datosCursoEstudiante", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = docenteDetallesCurso()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorEstudiante, detalles)
        transaccion.commit()
    }

    override fun enviarDatosCurso2(id: String, nombre: String, grado: String, horario: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosCursoAc(id: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(ced: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(
        ced: String,
        nombre: String,
        correo: String,
        calificacion: String
    ) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(ced: String, nombre: String, correo: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(estudiante: Boolean) {
        val bundle = Bundle()
        bundle.putBoolean("datosDocente", estudiante)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminGdDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorEstudiante, detalles)
        transaccion.commit()
    }

    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosEstudiante(ced: String, nombre: String, grado: String) {
        TODO("Not yet implemented")
    }
}