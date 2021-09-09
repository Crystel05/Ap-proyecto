package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TableRow
import kotlinx.android.synthetic.main._admin_pricipal.view.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum1
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum2
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum3
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum4
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum5
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum6
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum7
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.colum8
import kotlinx.android.synthetic.main.admin_ge_lista_estudiantes.view.*

class adminGeListaEstudiantes : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controller = ControladorComponentesVista()
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

        val listaCol = listOf<TableRow>(view.colum1, view.colum2, view.colum3, view.colum4, view.colum5, view.colum6, view.colum7, view.colum8)
        val listaNoms = listOf(view.cedula1.toString(), view.cedula2.toString(), view.cedula3.toString(), view.cedula4.toString(),
            view.cedula5.toString(), view.cedula6.toString(), view.cedula7.toString(), view.cedula8.toString())
        val listaGrados = listOf(view.nombre1.toString(), view.nombre2.toString(), view.nombre3.toString(), view.nombre4.toString(),
            view.nombre5.toString(), view.nombre6.toString(), view.nombre7.toString(), view.nombre8.toString())

        for (i in listaCol.indices){
            listaCol[i].setOnClickListener(){
                comunicador.enviarDatosDocente(listaNoms[i], listaGrados[i])
            }
        }
        view.agregarNuevoEstudiante.setOnClickListener() {
            val crearEstudiante = adminGeCrear()
            controller.cambiarFragment(crearEstudiante, view.contenedor, activity!!)
        }

//        view.colum1.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE1.text.toString(), view.grado1.text.toString())
//        }
//
//        view.colum2.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE2.text.toString(), view.grado2.text.toString())
//        }
//
//        view.colum3.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE3.text.toString(), view.grado3.text.toString())
//        }
//
//        view.colum4.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE4.text.toString(), view.grado4.text.toString())
//        }
//
//        view.colum5.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE5.text.toString(), view.grado5.text.toString())
//        }
//
//        view.colum6.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE6.text.toString(), view.grado6.text.toString())
//        }
//
//        view.colum7.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE7.text.toString(), view.grado7.text.toString())
//        }
//
//        view.colum8.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.nomE8.text.toString(), view.grado8.text.toString())
//        }
    }

//    fun cambiarFragment(fragment: Fragment){
//        val transacion = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
//        transacion.replace(R.id.contenedor, fragment)
//        transacion.commit()
//    }
}