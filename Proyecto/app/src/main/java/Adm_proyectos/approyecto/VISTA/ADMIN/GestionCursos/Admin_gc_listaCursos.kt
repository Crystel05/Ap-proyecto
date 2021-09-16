package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

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
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.*

class admin_gc_listaCursos : Fragment() {

    private val controller = ControladorComponentesVista()
    private val controllerAdmin = ControladorAdmin()
    private var crearCurso = admin_gc_crear()
    private lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.admin_gc_lista_cursos, container, false)
        comunicador = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaIds = listOf<TextView>(view.id1, view.id2, view.id3, view.id4,
            view.id5, view.id6, view.id7, view.id8)
        val listaNoms = listOf<TextView>(view.nombre1, view.nombre2, view.nombre3, view.nombre4,
            view.nombre5, view.nombre6, view.nombre7, view.nombre8)

        controllerAdmin.llenarListasCursos(listaIds, listaNoms)

        view.agregarNuevoCurso.setOnClickListener() {
            controller.cambiarFragment(crearCurso, R.id.contenedor, activity!!)
        }

        view.columna1.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id1.text.toString(), view.nombre1.text.toString())
        }

        view.columna2.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id2.text.toString(), view.nombre2.text.toString())
        }

        view.columna3.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id3.text.toString(), view.nombre3.text.toString())
        }

        view.columna4.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id4.text.toString(), view.nombre4.text.toString())
        }

        view.columna5.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id5.text.toString(), view.nombre5.text.toString())
        }

        view.columna6.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id6.text.toString(), view.nombre6.text.toString())
        }

        view.columna7.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id7.text.toString(), view.nombre7.text.toString())
        }

        view.columna8.setOnClickListener() {
            comunicador.enviarDatosCurso(view.id8.text.toString(), view.nombre8.text.toString())
        }
    }
}