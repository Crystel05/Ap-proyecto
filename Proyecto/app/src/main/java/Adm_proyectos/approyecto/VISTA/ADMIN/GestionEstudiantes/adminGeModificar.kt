package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes.adminGdListaDocentes
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gd_modificar.view.*
import kotlinx.android.synthetic.main.admin_ge_modificar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adminGeModificar : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_modificar, container, false)
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
            gradosGeM.adapter = adapter
        }

        guardarCambiosEstudiante.setOnClickListener(){
            cedulaModificarEstudiante.text.clear()
            nombreModificarEstudiante.text.clear()
            primerApModificarEst.text.clear()
            segundoApModificarEst.text.clear()
//            updateEstudiante()
        }

    }

    fun updateEstudiante(nombreViejo: String, apellidoViejo:String ,cedula: String, nombre: String, correo: String, contra: String, apellido: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.updateEstudiante(nombreViejo, apellidoViejo, cedula, nombre, correo, contra, apellido, grado)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val resultados = call.body()
                    if (resultados != null) {
                        print(resultados)
                        val resultado = resultados?.get(0)?.get("actualizaralumno")
                        if (resultado.asInt == 0) {
                            notifications("Se actulizó el estudiante con éxito!!")
                            guardadoExitos()
                        }else{
                            notifications("No se pudo actualizar el estudiante, intente de nuevo")
                        }
                    }
                    else{
                        notifications("No se pudo actualizar el estudiante, intente de nuevo")
                    }
                } else {
                    notifications("Error al conectar con la base de datos, intente de nuevo")
                }
            }
        }
    }

    private fun guardadoExitos() {
        cedulaModificarEstudiante.text.clear()
        nombreModificarEstudiante.text.clear()
        primerApModificarEst.text.clear()
        segundoApModificarEst.text.clear()
        val lista = adminGeListaEstudiantes()
        controller.cambiarFragment(lista, R.id.contenedor, activity!!)
    }

    private fun notifications(notifiacion: String){
        Toast.makeText(activity!!, notifiacion, Toast.LENGTH_LONG).show()
    }

    private fun llenarDatos() {
        val datos = arguments?.getStringArray("datosDocenteModificar")
        val cedula = datos?.get(0).toString()
        val nombreCom = datos?.get(1)?.split(" ")
        val correo = datos?.get(2)
        val nombre = nombreCom?.get(0)
        val ap1 = nombreCom?.get(1)
        var ap2 = ""
        if(nombreCom?.size == 3 ) {
            ap2 = nombreCom[2]
        }

    }

}