package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.graphics.Color
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_ac_lista_docentes.*
import kotlinx.android.synthetic.main.admin_ac_lista_docentes.view.*

class adminAcListaDocentes : Fragment() {

    private val controller = ControladorAdmin()
    private val cont = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_lista_docentes, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCeds = listOf<TextView>(view.cedulaAcD1, view.cedulaAcD2, view.cedulaAcD3, view.cedulaAcD4,
            view.cedulaAcD5, view.cedulaAcD6, view.cedulaAcD7, view.cedulaAcD8)
        val listaNoms = listOf<TextView>(view.nombreAcD1, view.nombreAcD2, view.nombreAcD3, view.nombreAcD4,
            view.nombreAcD5, view.nombreAcD6, view.nombreAcD7, view.nombreAcD8)

        var nombreSelec: TextView = nombreAcD1
        var cedulaSelec: TextView = cedulaAcD1
        val columnas = listOf<TableRow>(view.colum1, view.colum2, view.colum3, view.colum4, view.colum5, view.colum6, view.colum7, view.colum8)

        controller.llenarListaDocentes(listaCeds, listaNoms)

        colum1.setOnClickListener(){
            colum1.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum1)
            nombreSelec = nombreAcD1
            cedulaSelec = cedulaAcD1
        }

        colum2.setOnClickListener(){
            colum2.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum2)
            nombreSelec = nombreAcD2
            cedulaSelec = cedulaAcD2
        }

        colum3.setOnClickListener(){
            colum3.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum3)
            nombreSelec = nombreAcD3
            cedulaSelec = cedulaAcD3
        }

        colum4.setOnClickListener(){
            colum4.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum4)
            nombreSelec = nombreAcD4
            cedulaSelec = cedulaAcD4
        }

        colum5.setOnClickListener(){
            colum5.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum5)
            nombreSelec = nombreAcD5
            cedulaSelec = cedulaAcD5
        }

        colum6.setOnClickListener(){
            colum6.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum6)
            nombreSelec = nombreAcD6
            cedulaSelec = cedulaAcD6
        }

        colum7.setOnClickListener(){
            colum7.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum7)
            nombreSelec = nombreAcD7
            cedulaSelec = cedulaAcD7
        }

        colum8.setOnClickListener(){
            colum8.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            columnaSeleccionada(columnas, colum8)
            nombreSelec = nombreAcD8
            cedulaSelec = cedulaAcD8
        }

        agregarNuevoProfesor.setOnClickListener(){
            val nombre = nombreSelec.text.toString()
            val cedula = cedulaSelec.text.toString()
            //Usar datos
            Toast.makeText(activity!!, "El docente fue seleccionado con éxito", Toast.LENGTH_LONG).show()
            columnaSeleccionada(columnas, null)
            val detalles = adminAcDetalles()
            cont.cambiarFragment(detalles, R.id.contenedor, activity!!)
        }
    }

    fun columnaSeleccionada(columnas:List<TableRow>, columnaActual: TableRow?){
        for (colum in columnas) {
            if (colum != columnaActual)
                colum.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
    }
}