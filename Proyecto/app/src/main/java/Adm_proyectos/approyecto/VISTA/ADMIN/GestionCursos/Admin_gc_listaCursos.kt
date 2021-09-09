package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TableRow
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.*

class admin_gc_listaCursos : Fragment() {

    private val controller = ControladorComponentesVista()
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
        val listaCol = listOf<TableRow>(view.columna1, view.columna2, view.columna3, view.columna4, view.columna5, view.columna6, view.columna7, view.columna8)
        val listaIds = listOf(view.id1.toString(), view.id2.toString(), view.id3.toString(), view.id4.toString(),
            view.id5.toString(), view.id6.toString(), view.id7.toString(), view.id8.toString())
        val listaNoms = listOf(view.nombre1.toString(), view.nombre2.toString(), view.nombre3.toString(), view.nombre4.toString(),
            view.nombre5.toString(), view.nombre6.toString(), view.nombre7.toString(), view.nombre8.toString())

        for (i in listaCol.indices) {
            listaCol[i].setOnClickListener() {
                comunicador.enviarDatosCurso(listaIds[i], listaNoms[i])
            }
        }
//        view.agregarNuevoCurso.setOnClickListener() {
//            controller.cambiarFragment(crearCurso, view.contenedor, activity!!)
//        }
//        view.columna1.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id1.text.toString(), view.nombre1.text.toString())
//        }
//
//        view.columna2.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id2.text.toString(), view.nombre2.text.toString())
//        }
//
//        view.columna3.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id3.text.toString(), view.nombre3.text.toString())
//        }
//
//        view.columna4.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id4.text.toString(), view.nombre4.text.toString())
//        }
//
//        view.columna5.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id5.text.toString(), view.nombre5.text.toString())
//        }
//
//        view.columna6.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id6.text.toString(), view.nombre6.text.toString())
//        }
//
//        view.columna7.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id7.text.toString(), view.nombre7.text.toString())
//        }
//
//        view.columna8.setOnClickListener() {
//            comunicador.enviarDatosCurso(view.id8.text.toString(), view.nombre8.text.toString())
//        }
    }
}