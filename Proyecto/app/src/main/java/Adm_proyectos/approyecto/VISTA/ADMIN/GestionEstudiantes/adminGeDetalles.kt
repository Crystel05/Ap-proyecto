package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adminGeDetalles : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_detalles, container, false)

        val array = arguments?.getStringArray("datosEstudianteNuevo")
        val ced = array?.get(0)
        val nomD = array?.get(1)
        view.cedulaE.text = ced
        view.nombreE.text = nomD
        view.gradoE.text = array?.get(3)
        if (array?.get(2) == "2"){
            view.modificarEstudianteE.visibility = View.INVISIBLE
            view.eliminarEstudiante.visibility = View.INVISIBLE

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.verListaEstdiante.setOnClickListener(){
            cursosEstudiante("")
        }

        view.modificarEstudianteE.setOnClickListener(){
            val modificar = adminGeModificar()
            controller.cambiarFragment(modificar, R.id.contenedor, activity!!)
        }

        view.eliminarEstudiante.setOnClickListener(){
            //eliminar
            Toast.makeText(activity!!, "El estudiante fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val lista = adminGeListaEstudiantes()
            controller.cambiarFragment(lista, R.id.contenedor, activity!!)
        }
    }

    fun cursosEstudiante(correo: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosEstudiante(correo)

            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val cursos = call.body()
                    print(cursos)
                    if (cursos != null) {
                        for (curso in cursos) {
                            print(curso?.get("nombre").toString() + "\n")
                        }
                    }
                } else {
                    print("Error! Conexion con el API Fallida")
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