package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosAdmin
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_detalles.*
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class AdminGeDetalles : Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var correoE: String
    private lateinit var contraE: String
    private lateinit var comunicador: DatosAdmin
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_detalles, container, false)
        comunicador = activity as DatosAdmin
        val array = arguments?.getStringArray("datosEstudiante")

        if (array?.get(0) == "2"){
            view.modificarEstudianteE.visibility = View.INVISIBLE
            view.eliminarEstudiante.visibility = View.INVISIBLE

        }
        val ced = array?.get(1)
        val nomD = array?.get(2)
        val gradoE = array?.get(3)
        correoE = array?.get(4).toString()
        contraE = array?.get(5).toString()
        view.cedulaE.text = nomD
        view.nombreE.text = ced
        view.gradoE.text = gradoE

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.verListaEstdiante.setOnClickListener(){
            cursosEstudiante(correoE)
        }

        view.modificarEstudianteE.setOnClickListener(){
            val modificar = AdminGeModificar()
            comunicador.enviarDatosEstudiante(cedulaE.text.toString(), nombreE.text.toString(), gradoE.text.toString(), correoE, contraE, modificar)
        }

        view.eliminarEstudiante.setOnClickListener(){
            //eliminar
            Toast.makeText(activity!!, "El estudiante fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val lista = AdminGeListaEstudiantes()
            controller.cambiarFragment(lista, R.id.contenedor, activity!!)
        }
    }

    fun cursosEstudiante(correo: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosEstudiante(correo)

            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val cursos = call.body()
                    val cursosDatos = ArrayList<String>()
                    if (cursos != null) {
                        for (curso in cursos) {
                            cursosDatos.add(curso.get("nombre").toString().replace("\"", "")+
                                    "_"+curso.get("codigo").toString().replace("\"", ""))
                        }
                    }
                    comunicador.cursosPopUp(cursosDatos)
                } else {
                    controller.notificacion("Error! Conexion con el API Fallida", activity!!)
                }
            }
        }
    }

//    fun popUp(){
//        val dialogo = popUpCursos()
//        dialogo.show(activity!!.supportFragmentManager, "Cursos estudiante")
//    }

    private fun notificacions(notificacion: String) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }
}