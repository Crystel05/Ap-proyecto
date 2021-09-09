package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import kotlinx.android.synthetic.main.docentes_lista_estudiantes.view.*

class docentesListaEstudiantes : Fragment() {

    private lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        comunicador = activity as Comunicador
        val view = inflater.inflate(R.layout.docentes_lista_estudiantes, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCol = listOf<TableRow>(view.colum1, view.colum2, view.colum3, view.colum4, view.colum5, view.colum6, view.colum7, view.colum8)
        val listagradoDcs = listOf(view.gradoDcE1.toString(), view.gradoDcE2.toString(), view.gradoDcE3.toString(), view.gradoDcE4.toString(),
            view.gradoDcE5.toString(), view.gradoDcE6.toString(), view.gradoDcE7.toString(), view.gradoDcE8.toString())
        val listaNoms = listOf(view.nomDcE1.toString(), view.nomDcE2.toString(), view.nomDcE3.toString(), view.nomDcE4.toString(),
            view.nomDcE5.toString(), view.nomDcE6.toString(), view.nomDcE7.toString(), view.nomDcE8.toString())

        for (i in listaCol.indices){
            listaCol[i].setOnClickListener(){
                comunicador.enviarDatosCurso(listagradoDcs[i], listaNoms[i])
            }
        }
//
//        view.colum1.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE1.text.toString(), view.nomDcE1.text.toString())
//        }
//
//        view.colum2.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE2.text.toString(), view.nomDcE2.text.toString())
//        }
//
//        view.colum3.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE3.text.toString(), view.nomDcE3.text.toString())
//        }
//
//        view.colum4.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE4.text.toString(), view.nomDcE4.text.toString())
//        }
//
//        view.colum5.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE5.text.toString(), view.nomDcE5.text.toString())
//        }
//
//        view.colum6.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE6.text.toString(), view.nomDcE6.text.toString())
//        }
//
//        view.colum7.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE7.text.toString(), view.nomDcE7.text.toString())
//        }
//
//        view.colum8.setOnClickListener(){
//            comunicador.enviarDatosEstudiante(view.gradoDcE8.text.toString(), view.nomDcE8.text.toString())
//        }

    }

}