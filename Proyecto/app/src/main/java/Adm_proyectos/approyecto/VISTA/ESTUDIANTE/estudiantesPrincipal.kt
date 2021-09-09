package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.DOCENTE.docenteDetallesCurso
import Adm_proyectos.approyecto.VISTA.DOCENTE.docenteListaCursos
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.ControlAction
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main._estudiantes_principal.*

class estudiantesPrincipal : AppCompatActivity(), Comunicador {

    private val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._estudiantes_principal)
        val listaCursos = docenteListaCursos()
        controller.cambiarFragment(listaCursos, contenedorEstudiante, this)
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

    override fun enviarDatosCursoAc(id: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(ced: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        TODO("Not yet implemented")
    }
}