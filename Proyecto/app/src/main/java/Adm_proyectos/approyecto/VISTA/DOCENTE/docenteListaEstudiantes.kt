package Adm_proyectos.approyecto.VISTA.DOCENTE

import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.docentes_lista_estudiantes.view.*

class docentesListaEstudiantes : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controller = ControladorAdmin()

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

        val listagradoDcs = listOf<TextView>(view.gradoDcE1, view.gradoDcE2, view.gradoDcE3, view.gradoDcE4,
            view.gradoDcE5, view.gradoDcE6, view.gradoDcE7, view.gradoDcE8)
        val listaNoms = listOf<TextView>(view.nomDcE1, view.nomDcE2, view.nomDcE3, view.nomDcE4,
            view.nomDcE5, view.nomDcE6, view.nomDcE7, view.nomDcE8)

        controller.llenarListasEstudiantes(listaNoms, listagradoDcs)

        view.colum1.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE1.text.toString(), view.nomDcE1.text.toString())
        }

        view.colum2.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE2.text.toString(), view.nomDcE2.text.toString())
        }

        view.colum3.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE3.text.toString(), view.nomDcE3.text.toString())
        }

        view.colum4.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE4.text.toString(), view.nomDcE4.text.toString())
        }

        view.colum5.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE5.text.toString(), view.nomDcE5.text.toString())
        }

        view.colum6.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE6.text.toString(), view.nomDcE6.text.toString())
        }

        view.colum7.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE7.text.toString(), view.nomDcE7.text.toString())
        }

        view.colum8.setOnClickListener(){
            comunicador.enviarDatosEstudiante(view.gradoDcE8.text.toString(), view.nomDcE8.text.toString())
        }

    }

}