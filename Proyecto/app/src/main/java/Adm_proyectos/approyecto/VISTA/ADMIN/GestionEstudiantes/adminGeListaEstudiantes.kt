package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_lista_estudiantes.view.*

class adminGeListaEstudiantes : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controller = ControladorComponentesVista()
    private val controllerAdmin = ControladorAdmin()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_lista_estudiantes, container, false)
        comunicador = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaGrados = listOf<TextView>(view.grado1, view.grado2, view.grado3, view.grado4,
            view.grado5, view.grado6, view.grado7, view.grado8)
        val listaNombres = listOf<TextView>(view.nomE1, view.nomE2, view.nomE3, view.nomE4,
            view.nomE5, view.nomE6, view.nomE7, view.nomE8)

        controllerAdmin.llenarListasEstudiantes(listaNombres, listaGrados)

        view.agregarNuevoEstudiante.setOnClickListener() {
            val crearEstudiante = adminGeCrear()
            controller.cambiarFragment(crearEstudiante, R.id.contenedor, activity!!)
        }

        view.colum1.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE1.text.toString(), view.grado1.text.toString())
        }

        view.colum2.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE2.text.toString(), view.grado2.text.toString())
        }

        view.colum3.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE3.text.toString(), view.grado3.text.toString())
        }

        view.colum4.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE4.text.toString(), view.grado4.text.toString())
        }

        view.colum5.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE5.text.toString(), view.grado5.text.toString())
        }

        view.colum6.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE6.text.toString(), view.grado6.text.toString())
        }

        view.colum7.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE7.text.toString(), view.grado7.text.toString())
        }

        view.colum8.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.nomE8.text.toString(), view.grado8.text.toString())
        }
    }

}