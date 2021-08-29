package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdDetalles
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdListaDocentes
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.app.Dialog
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main._admin_pricipal.*
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.*

class adminPricipal : AppCompatActivity(), Comunicador {

    private lateinit var popUp : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._admin_pricipal)

        popUp = Dialog(this)

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

        }

        adminAC.setOnClickListener(){

        }
    }

    override fun enviarDatosCurso(id: String, nombre:String) {
        val bundle = Bundle()
        bundle.putString("datosCurso", id)
        var datos = arrayOf(id, nombre)
        bundle.putStringArray("datosCurso", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = admin_gc_detalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun enviarDatosDocente(ced: String, nombre: String) {
        val bundle = Bundle()
        bundle.putString("datosDocente", ced)

        var datos = arrayOf(ced, nombre)
        bundle.putStringArray("datosDocente", datos)

        val transaccion = this.supportFragmentManager.beginTransaction()
        val detalles = adminGdDetalles()
        detalles.arguments = bundle

        transaccion.replace(R.id.contenedor, detalles)
        transaccion.commit()

    }

    fun popUp(){

        popUp.setContentView(R.layout.pop_up_lista_cursos)
//        val cerrar = popUp.findViewById<ImageView>(R.id.cerrar)
//        cerrar.setOnClickListener(){
//            popUp.dismiss()
//        }
        popUp.show()
    }


    fun cambiarFragment(fragment: Fragment){
        val transacion = supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }


}

