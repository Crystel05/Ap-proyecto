package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_crear.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adminGeCrear : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_crear, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter.createFromResource(
            context!!,
            R.array.ListaGrados,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            gradosGeA.adapter = adapter
        }

        agregarEstudiante.setOnClickListener(){
            agregar()
        }

    }

    private fun agregar() {
        if (cedulaCrearEst.text.isNotEmpty() && nombreCrearEst.text.isNotEmpty() && correoCrearEst.text.isNotEmpty() && contrEstCrear.text.isNotEmpty()
            && primerApCrearEst.text.isNotEmpty()){
            insertarEstudiante(
                cedulaCrearEst.text.toString(),
                nombreCrearEst.text.toString(),
                correoCrearEst.text.toString(),
                contrEstCrear.text.toString(),
                primerApCrearEst.text.toString() + " " + segundoApCrearEst.text.toString(),
                gradosGeA.selectedItem.toString()
            )
        } else {
            notificacions("Existen campos sin llenar")
        }
    }


    fun insertarEstudiante(cedula: String, nombre: String, correo: String, contra: String, apellido: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarEstudiante(cedula, nombre, correo, contra, apellido, grado)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val resultados = call.body()
                    if (resultados != null) {
                        print(resultados)
                        val resultado = resultados?.get(0)?.get("insertaralumno")
                        if (resultado.asInt == 0) {
                            notificacions("Estudiante agregado con éxito!!")
                            insertadoExitoso(true)
                        }else{
                            notificacions("Error al insertar ek estudiante, intente de nuevo")
                        }
                    }
                    else{
                        notificacions("Error al insertar ek estudiante, intente de nuevo")
                    }
                } else {
                    notificacions("Error al conectar con la base de datos")
                }
            }
        }
    }

    private fun insertadoExitoso(insertar:Boolean) {
        cedulaCrearEst.text.clear()
        nombreCrearEst.text.clear()
        correoCrearEst.text.clear()
        contrEstCrear.text.clear()
        primerApCrearEst.text.clear()

        if (insertar) {
            val listaEsts = adminGeListaEstudiantes()
            controller.cambiarFragment(listaEsts, R.id.contenedor, activity!!)
        }
    }

    private fun notificacions(notificacion: String) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }

}