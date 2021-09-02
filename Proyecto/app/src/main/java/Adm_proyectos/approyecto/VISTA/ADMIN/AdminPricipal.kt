package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.controladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos.adminAcDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos.adminAcListaCursos
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdListaDocentes
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.adminGeDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes.adminGeListaEstudiantes
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main._admin_pricipal.*

class adminPricipal : AppCompatActivity(), Comunicador {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._admin_pricipal)

        val listaCurso = admin_gc_listaCursos()
        cambiarFragment(listaCurso)


        adminGC.setOnClickListener(){
            cambiarFragment(listaCurso)
        }

        adminGD.setOnClickListener(){
            val listaDocentes = adminGdListaDocentes()
            cambiarFragment(listaDocentes)
        }

        adminGE.setOnClickListener(){
            val listaEstudiantes = adminGeListaEstudiantes()
            cambiarFragment(listaEstudiantes)
        }

        adminAC.setOnClickListener(){
            val cursos = adminAcListaCursos()
            cambiarFragment(cursos)
        }

        val correo = intent.getStringExtra("CORREO")
        val contrasenna = intent.getStringExtra("CONTRASENNA")
        nombreUsuario.text = " $correo" //cambiar esto después

        prueba.setOnClickListener(){
            val cont = controladorComponentesVista()
            cont.prueba(this, "1", prueba)
        }
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

    override fun enviarDatosEstudiante(ced: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosEstudiante", ced)

        val datos = arrayOf(ced, nombre)
        bundle.putStringArray("datosEstudiante", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminGeDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()
    }


    fun cambiarFragment(fragment: Fragment){
        val transacion = supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }


}

