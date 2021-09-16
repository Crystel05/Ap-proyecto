package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.graphics.Color
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.*
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.view.*


class adminAcListaEstudiantes : Fragment() {

    val controller = ControladorAdmin()
    val cont = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_lista_estudiantes, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val clickeada = ArrayList<Int>()
        val click = listOf(0, 0, 0, 0, 0, 0, 0, 0)
        clickeada.addAll(click)

        val listaGrados = listOf<TextView>(view.gradoAcE1, view.gradoAcE2, view.gradoAcE3, view.gradoAcE4,
            view.gradoAcE5, view.gradoAcE6, view.gradoAcE7, view.gradoAcE8)
        val listaNombres = listOf<TextView>(view.nomAcE1, view.nomAcE2, view.nomAcE3, view.nomAcE4,
            view.nomAcE5, view.nomAcE6, view.nomAcE7, view.nomAcE8)

        controller.llenarListasEstudiantes(listaNombres, listaGrados)

        val columnas = ArrayList<String>()
        val cols = listOf(nomAcE1.text.toString()+"_"+gradoAcE1.text.toString(), nomAcE2.text.toString()+"_"+gradoAcE2.text.toString(), nomAcE3.text.toString()+"_"+gradoAcE3.text.toString(),
            nomAcE4.text.toString()+"_"+gradoAcE4.text.toString(), nomAcE5.text.toString()+"_"+gradoAcE5.text.toString(), nomAcE6.text.toString()+"_"+gradoAcE6.text.toString(),
            nomAcE7.text.toString()+"_"+gradoAcE7.text.toString(), nomAcE8.text.toString()+"_"+gradoAcE8.text.toString())
        columnas.addAll(cols)



        colum1.setOnClickListener(){
            seleccionar(clickeada, 0, colum1)
        }

        colum2.setOnClickListener(){
            seleccionar(clickeada, 1, colum2)
        }

        colum3.setOnClickListener(){
            seleccionar(clickeada, 2, colum3)
        }

        colum4.setOnClickListener(){
            seleccionar(clickeada, 3, colum4)
        }

        colum5.setOnClickListener(){
            seleccionar(clickeada, 4, colum5)
        }

        colum6.setOnClickListener(){
            seleccionar(clickeada, 5, colum6)
        }

        colum7.setOnClickListener(){
            seleccionar(clickeada, 6, colum7)
        }

        colum8.setOnClickListener(){
            seleccionar(clickeada, 7, colum8)
        }

        agregarEstudiantesAc.setOnClickListener(){
            val estudiantes = ArrayList<String>()
            var i = 0
            for (selec in clickeada){
                if (selec == 1){
                    estudiantes.add(columnas[i])
                    i +=1
                }
                else
                    i+=1
            }
            val detalles = adminAcDetalles()
            cont.cambiarFragment(detalles, R.id.contenedor, activity!!)
            Toast.makeText(activity!!, "Los estudiantes fueron agregados al curso con éxito", Toast.LENGTH_LONG).show()
        }
    }

    fun seleccionar(clickeada: ArrayList<Int>, posicion: Int, columnaActual: TableRow){
        if (clickeada[posicion] == 1) {
            columnaActual.setBackgroundResource(R.drawable.seleccionada)
            clickeada[posicion] = 0
        }
        else {
            columnaActual.setBackgroundColor(Color.parseColor("#5A9CE8"))
            clickeada[posicion] = 1
        }
    }

}