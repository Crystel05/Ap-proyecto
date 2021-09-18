package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.popUpCursos
import Adm_proyectos.approyecto.VISTA.ESTUDIANTE.estudianteCalificarDocente
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador2
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gd_detalles.*
import kotlinx.android.synthetic.main.admin_gd_detalles.listCursos
import kotlinx.android.synthetic.main.admin_gd_detalles.view.*
import kotlinx.android.synthetic.main.admin_ge_detalles.*
import kotlinx.android.synthetic.main.pop_up_lista_cursos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class adminGdDetalles : Fragment() {

    private val controller = ControladorComponentesVista()
    private lateinit var correo: String
    private lateinit var comunicador:Comunicador2
    private lateinit var comunicador2: Comunicador
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_detalles, container, false)
        val array = arguments?.getStringArray("datosDocenteNuevo")
        comunicador = activity as Comunicador2
        comunicador2 = activity as Comunicador
        val ced = array?.get(1)
        val nomD = array?.get(0)
        correo = array?.get(2).toString()
        val calificacion = array?.get(3)
        view.cedulaD.text = ced
        view.nombreD.text = nomD
        view.correoD.text = correo
        view.ratingD.rating = calificacion?.toFloat() ?: 0.0F
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val esEst = arguments?.getBoolean("datosDocente")

        view.verListaDocente.setOnClickListener(){
            cursosProfesor(correo)
        }

        view.modificarDocenteP.setOnClickListener(){
            comunicador2.enviarDatosDocente(cedulaD.text.toString(), nombreD.text.toString(), correoD.text.toString())
        }

        eliminarDocente.setOnClickListener(){
            Toast.makeText(activity!!, "El docente fue eliminado con éxito", Toast.LENGTH_LONG).show()
            val listaDocentes = adminGdListaDocentes()
            controller.cambiarFragment(listaDocentes, R.id.contenedor, activity!!)
        }

        if(esEst == true){
            eliminarDocente.visibility = View.INVISIBLE
            modificarDocenteP.visibility = View.INVISIBLE
            listCursos.visibility = View.INVISIBLE
            verListaDocente.visibility = View.INVISIBLE
            calificarProfesor.visibility = View.VISIBLE
        }
        calificarProfesor.setOnClickListener(){
            popUp2()
        }

    }

    fun cursosProfesor(correo: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosProfesor(correo)
            print(call)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val cursos = call.body()
                    val cursosDatos = ArrayList<String>()
                    print(cursos)
                    if (cursos != null) {
                        for (curso in cursos) {
                            cursosDatos.add(curso.get("nombre").toString().replace("\"", "")+
                                    "_"+curso.get("codigo").toString().replace("\"", ""))
                        }
                        comunicador.cursosDocente(cursosDatos)
                    }
                } else {
                    print("Error! Conexion con el API Fallida")
                }
            }
        }
    }

    private fun imprimir(notificacion: String?) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }

//    fun popUp(){
//        val dialogo = popUpCursos()
//        dialogo.show(activity!!.supportFragmentManager, "Prueba")
//    }

    fun popUp2(){
        val dialogo = estudianteCalificarDocente()
        dialogo.show(activity!!.supportFragmentManager, "Prueba")
    }
}