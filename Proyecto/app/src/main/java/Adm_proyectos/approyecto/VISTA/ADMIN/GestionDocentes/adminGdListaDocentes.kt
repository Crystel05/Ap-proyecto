package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre1
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre2
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre3
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre4
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre5
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre6
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre7
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.nombre8

class adminGdListaDocentes : Fragment() {

    private val crearDocente = adminGdCrearDocente()
    private lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_lista_docentes, container, false)
        comunicador = activity as Comunicador
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.agregarNuevoProfesor.setOnClickListener() {
//            cambiarFragment(crearDocente)

        }
        view.colum1.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula1.text.toString(), view.nombre1.text.toString())
        }

        view.colum2.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula2.text.toString(), view.nombre2.text.toString())
        }

        view.colum3.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula3.text.toString(), view.nombre3.text.toString())
        }

        view.colum4.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula4.text.toString(), view.nombre4.text.toString())
        }

        view.colum5.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula5.text.toString(), view.nombre5.text.toString())
        }

        view.colum6.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula6.text.toString(), view.nombre6.text.toString())
        }

        view.colum7.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula7.text.toString(), view.nombre7.text.toString())
        }

        view.colum8.setOnClickListener(){
            comunicador.enviarDatosDocente(view.cedula8.text.toString(), view.nombre8.text.toString())
        }
    }

    fun cambiarFragment(fragment: Fragment){
        val transacion = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedor, fragment)
        transacion.commit()
    }
}