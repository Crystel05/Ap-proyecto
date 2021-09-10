package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

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
import kotlinx.android.synthetic.main.admin_ac_lista_cursos.view.*

class adminAcListaCursos : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controller = ControladorAdmin()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_lista_cursos, container, false)
        comunicador = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaIds = listOf<TextView>(view.idAc1, view.idAc2, view.idAc3, view.idAc4,
            view.idAc5, view.idAc6, view.idAc7, view.idAc8)
        val listaNoms = listOf<TextView>(view.nombreAc1, view.nombreAc2, view.nombreAc3, view.nombreAc4,
            view.nombreAc5, view.nombreAc6, view.nombreAc7, view.nombreAc8)

        controller.llenarListasCursos(listaIds, listaNoms)

        view.columna1.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc1.text.toString(), view.nombreAc1.text.toString())
        }

        view.columna2.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc2.text.toString(), view.nombreAc2.text.toString())
        }

        view.columna3.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc3.text.toString(), view.nombreAc3.text.toString())
        }

        view.columna4.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc4.text.toString(), view.nombreAc4.text.toString())
        }

        view.columna5.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc5.text.toString(), view.nombreAc5.text.toString())
        }

        view.columna6.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc6.text.toString(), view.nombreAc6.text.toString())
        }

        view.columna7.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc7.text.toString(), view.nombreAc7.text.toString())
        }

        view.columna8.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc8.text.toString(), view.nombreAc8.text.toString())
        }
    }

}