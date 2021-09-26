package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import Adm_proyectos.approyecto.API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.AdminGdListaDocentes
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.AdminGdModificar
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosAdmin
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosEstudiante
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gd_detalles.*
import kotlinx.android.synthetic.main.admin_gd_detalles.view.*

class estudianteDetallesDocente:Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var correo: String
    private lateinit var calificacion: String
    private lateinit var ced: String
    private lateinit var contra: String
    private lateinit var comunicador: DatosEstudiante
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_detalles, container, false)
        val array = arguments?.getStringArray("datosDocente")
        comunicador = activity as DatosEstudiante
        ced = array?.get(0).toString()
        val nomD = array?.get(1)
        correo = array?.get(2).toString()
        calificacion = array?.get(3).toString()
        contra = array?.get(4).toString()
        view.cedulaD.text = ced
        view.nombreD.text = nomD
        view.correoD.text = correo
        view.ratingD.rating = calificacion.toFloat() ?: 0.0F

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eliminarDocente.visibility = View.INVISIBLE
        modificarDocenteP.visibility = View.INVISIBLE
        listCursos.visibility = View.INVISIBLE
        verListaDocente.visibility = View.INVISIBLE
        calificarProfesor.visibility = View.VISIBLE

        calificarProfesor.setOnClickListener{
            popUp2()
        }

    }

    fun popUp2(){
        val dialogo = estudianteCalificarDocente()
        dialogo.show(activity!!.supportFragmentManager, "Prueba")
    }

}