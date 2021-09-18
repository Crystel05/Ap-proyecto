package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gd_crear_docente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adminGdCrearDocente : Fragment() {

    val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.admin_gd_crear_docente, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        agregarProfesorNuevoCrear.setOnClickListener(){
            agregar()
        }

    }

    private fun agregar() {
        if (cedulaCrearDocente.text.isNotEmpty() && nombreCrearDocente.text.isNotEmpty() &&
            primerApellidoCrearDocente.text.isNotEmpty() && segundoApellidoCrearDocente.text.isNotEmpty() &&
            correoCrearDocente.text.isNotEmpty() && contrasennaCrearDocente.text.isNotEmpty()) {

                insertarDocente(
                    cedulaCrearDocente.text.toString(),
                    nombreCrearDocente.text.toString(),
                    primerApellidoCrearDocente.text.toString(),
                    segundoApellidoCrearDocente.text.toString(),
                    correoCrearDocente.text.toString(),
                    contrasennaCrearDocente.text.toString()
                )

        } else {
            notificacions("Existen campos sin llenar")
        }
    }

    fun insertarDocente(cedula: String, nombre: String, apellido1: String, apellido2: String, correo: String, contra: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarProfesor(cedula, nombre, correo, contra,
                "$apellido1 $apellido2"
            )
            activity!!.runOnUiThread {
                print(call)
                if (call.isSuccessful) {
                    val resultados = call.body()
                    if (resultados != null) {
                        print(resultados)
                        val resultado = resultados?.get(0)?.get("insertardocente")
                        if (resultado.asInt == 0) {
                            notificacions("Docente insertado con éxito!!")
                            insertadoExitoso(true)
                        }else{
                            notificacions("No se pudo insertar el docente, intente de nuevo")
                        }
                    }
                    else{
                        notificacions("No se pudo insertar el docente, intente de nuevo")
                    }
                } else {
                    notificacions("Error con la base de datos, intente de nuevo")
                }
            }
        }
    }

    private fun insertadoExitoso(insertar:Boolean) {
        cedulaCrearDocente.text.clear()
        nombreCrearDocente.text.clear()
        primerApellidoCrearDocente.text.clear()
        segundoApellidoCrearDocente.text.clear()
        correoCrearDocente.text.clear()
        contrasennaCrearDocente.text.clear()
        if (insertar) {
            val listaCursos = adminGdListaDocentes()
            controller.cambiarFragment(listaCursos, R.id.contenedor, activity!!)
        }
    }

    private fun notificacions(notificacion: String) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }


}