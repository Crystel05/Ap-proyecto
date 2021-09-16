package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.adminGeDetalles
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class docentePrincipal : AppCompatActivity(), Comunicador {

    private val controller = ControladorComponentesVista()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._docente_principal)

        val listaCursos = docenteListaCursos()
        controller.cambiarFragment(listaCursos, R.id.contenedorDocente, this)
    }

    override fun enviarDatosCurso(id: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosCursoDocente", id)
        val datos = arrayOf(id, nombre, "1")
        bundle.putStringArray("datosCursoDocente", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = docenteDetallesCurso()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedorDocente, detalles)
        transaccion.commit()
    }

    //tratar de cambiar después
    override fun enviarDatosCursoAc(id: String, nombre: String) {
        TODO("Not yet implemented")
    }

    override fun enviarDatosDocente(ced: String, nombre: String) {
        TODO("Not yet implemented")
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

        transaccion.replace(R.id.contenedorDocente, detalles)
        transaccion.commit()
    }
}