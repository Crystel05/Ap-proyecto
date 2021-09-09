package Adm_proyectos.approyecto.VISTA.DOCENTE

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TableRow
import kotlinx.android.synthetic.main.docente_lista_cursos.view.*

class docenteListaCursos : Fragment() {

    private lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        comunicador = activity as Comunicador
        val view = inflater.inflate(R.layout.docente_lista_cursos, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCol = listOf<TableRow>(view.columna1, view.columna2, view.columna3, view.columna4, view.columna5, view.columna6, view.columna7, view.columna8)
        val listaIds = listOf(view.idDc1.toString(), view.idDc2.toString(), view.idDc3.toString(), view.idDc4.toString(),
            view.idDc5.toString(), view.idDc6.toString(), view.idDc7.toString(), view.idDc8.toString())
        val listaNoms = listOf(view.nombreDc1.toString(), view.nombreDc2.toString(), view.nombreDc3.toString(), view.nombreDc4.toString(),
            view.nombreDc5.toString(), view.nombreDc6.toString(), view.nombreDc7.toString(), view.nombreDc8.toString())

        for (i in listaCol.indices){
            listaCol[i].setOnClickListener(){
                comunicador.enviarDatosCurso(listaIds[i], listaNoms[i])
            }
        }
        
//        view.columna1.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc1.text.toString(), view.nombreDc1.text.toString())
//        }
//
//        view.columna2.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc2.text.toString(), view.nombreDc2.text.toString())
//        }
//
//        view.columna3.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc3.text.toString(), view.nombreDc3.text.toString())
//        }
//
//        view.columna4.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc4.text.toString(), view.nombreDc4.text.toString())
//        }
//
//        view.columna5.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc5.text.toString(), view.nombreDc5.text.toString())
//        }
//
//        view.columna6.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc6.text.toString(), view.nombreDc6.text.toString())
//        }
//
//        view.columna7.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc7.text.toString(), view.nombreDc7.text.toString())
//        }
//
//        view.columna8.setOnClickListener(){
//            comunicador.enviarDatosCurso(view.idDc8.text.toString(), view.nombreDc8.text.toString())
//        }
    }
}