package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.graphics.Color
import android.widget.TableRow
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.*
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.agregarEstudiantesAc
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.gradoAcE1
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.nomAcE1
import kotlinx.android.synthetic.main.admin_ac_lista_estudiantes.nomAcE2


class adminAcListaEstudiantes : Fragment() {

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
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)
        clickeada.add(0)

        val columnas = ArrayList<String>()
        columnas.add(nomAcE1.text.toString()+"_"+gradoAcE1.text.toString())
        columnas.add(nomAcE2.text.toString()+"_"+gradoAcE2.text.toString())
        columnas.add(nomAcE3.text.toString()+"_"+gradoAcE3.text.toString())
        columnas.add(nomAcE4.text.toString()+"_"+gradoAcE4.text.toString())
        columnas.add(nomAcE5.text.toString()+"_"+gradoAcE5.text.toString())
        columnas.add(nomAcE6.text.toString()+"_"+gradoAcE6.text.toString())
        columnas.add(nomAcE7.text.toString()+"_"+gradoAcE7.text.toString())
        columnas.add(nomAcE8.text.toString()+"_"+gradoAcE8.text.toString())

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
            Toast.makeText(activity!!, "Los estudiantes fueron agregados al curso con éxito", Toast.LENGTH_LONG).show()
        }
    }

    fun seleccionar(clickeada: ArrayList<Int>, posicion: Int, columnaActual: TableRow){
        if (clickeada[posicion] == 1) {
            columnaActual.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            clickeada[posicion] = 0
        }
        else {
            columnaActual.setBackgroundColor(Color.parseColor("#FF69DCCB"))
            clickeada[posicion] = 1
        }
    }

}