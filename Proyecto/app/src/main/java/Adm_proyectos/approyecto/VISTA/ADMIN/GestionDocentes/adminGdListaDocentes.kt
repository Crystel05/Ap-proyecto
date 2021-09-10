package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TableRow
import android.widget.TextView
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

    private val controller = ControladorComponentesVista()
    private val controllerAdmin = ControladorAdmin()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCeds = listOf<TextView>(view.cedula1, view.cedula2, view.cedula3, view.cedula4,
            view.cedula5, view.cedula6, view.cedula7, view.cedula8)
        val listaNoms = listOf<TextView>(view.nombre1, view.nombre2, view.nombre3, view.nombre4,
            view.nombre5, view.nombre6, view.nombre7, view.nombre8)

        controllerAdmin.llenarListaDocentes(listaCeds, listaNoms)

        view.agregarNuevoProfesor.setOnClickListener() {
            controller.cambiarFragment(crearDocente, R.id.contenedor, activity!!)
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

}