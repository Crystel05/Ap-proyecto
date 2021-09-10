package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.docente_lista_cursos.view.*
import org.w3c.dom.Text

class docenteListaCursos : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controllerAd = ControladorAdmin()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        comunicador = activity as Comunicador
        val view = inflater.inflate(R.layout.docente_lista_cursos, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCol = listOf<TableRow>(view.columna1, view.columna2, view.columna3, view.columna4, view.columna5, view.columna6, view.columna7, view.columna8)
        val listaIds = listOf<TextView>(view.idDc1, view.idDc2, view.idDc3, view.idDc4,
            view.idDc5, view.idDc6, view.idDc7, view.idDc8)
        val listaNoms = listOf<TextView>(view.nombreDc1, view.nombreDc2, view.nombreDc3, view.nombreDc4,
            view.nombreDc5, view.nombreDc6, view.nombreDc7, view.nombreDc8)

        controllerAd.llenarListasCursos(listaIds, listaNoms)

        for (i in listaCol.indices){
            listaCol[i].setOnClickListener(){
                comunicador.enviarDatosCurso(listaIds[i].toString(), listaNoms[i].toString())
            }
        }

    }
}