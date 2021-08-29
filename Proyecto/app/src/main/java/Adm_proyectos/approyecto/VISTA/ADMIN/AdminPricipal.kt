package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class adminPricipal : AppCompatActivity(), Comunicador {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._admin_pricipal)
        val listaCurso = admin_gc_listaCursos()
        cambiarFragment(listaCurso)

    }

    override fun enviarDatos(id: String, nombre:String) {
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

    fun cambiarFragment(fragment: Fragment){
        val transacion = supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }


}