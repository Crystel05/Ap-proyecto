package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosAdmin
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminGdListaDocentes : Fragment() {

    private val controller = ControladorComponentesVista()
    private val crearDocente = AdminGdCrearDocente()
    private lateinit var comunicador: DatosAdmin

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gd_lista_docentes, container, false)
        comunicador = activity as DatosAdmin
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaCeds = listOf<TextView>(view.cedula1, view.cedula2, view.cedula3, view.cedula4,
            view.cedula5, view.cedula6, view.cedula7, view.cedula8)
        val lisCeds = ArrayList<TextView>()
        lisCeds.addAll(listaCeds)
        val listaNoms = listOf<TextView>(view.nombre1, view.nombre2, view.nombre3, view.nombre4,
            view.nombre5, view.nombre6, view.nombre7, view.nombre8)
        val lisNoms = ArrayList<TextView>()
        lisNoms.addAll(listaNoms)

        //controllerAdmin.llenarListaDocentes(listaCeds, listaNoms)
        obtenerProfesores(lisNoms, lisCeds, false)
        view.agregarNuevoProfesor.setOnClickListener() {
            controller.cambiarFragment(crearDocente, R.id.contenedor, activity!!)
        }
        view.colum1.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula1.text.toString(), view.nombre1.text.toString())
            enviarDatos(cedula1)
        }

        view.colum2.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula2.text.toString(), view.nombre2.text.toString())
            enviarDatos(cedula2)
        }

        view.colum3.setOnClickListener(){
          //  comunicador.enviarDatosDocente(view.cedula3.text.toString(), view.nombre3.text.toString())
            enviarDatos(cedula3)
        }

        view.colum4.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula4.text.toString(), view.nombre4.text.toString())
            enviarDatos(cedula4)
        }

        view.colum5.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula5.text.toString(), view.nombre5.text.toString())
            enviarDatos(cedula5)
        }

        view.colum6.setOnClickListener(){
          //  comunicador.enviarDatosDocente(view.cedula6.text.toString(), view.nombre6.text.toString())
            enviarDatos(cedula6)
        }

        view.colum7.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula7.text.toString(), view.nombre7.text.toString())
            enviarDatos(cedula7)
        }

        view.colum8.setOnClickListener(){
           // comunicador.enviarDatosDocente(view.cedula8.text.toString(), view.nombre8.text.toString())
            enviarDatos(cedula8)
        }

        view.adelante.setOnClickListener{
            obtenerProfesores(lisNoms, lisCeds, true)
        }
    }

    private fun obtenerProfesores(listaNoms: ArrayList<TextView>, listaCeds: ArrayList<TextView>, avanzar:Boolean){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getProfesores()
            val listaNomsA = ArrayList<String>()
            val listaCedsA = ArrayList<String>()
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val profesores = call.body()
                    if (profesores != null) {
                        for (profe in profesores) {
                            listaNomsA.add(profe.get("nombre").toString().replace("\"", ""))
                            listaCedsA.add(profe.get("cedula").toString().replace("\"", ""))
                        }
                        llenarLista(listaNomsA, listaCedsA, listaNoms, listaCeds, avanzar)
                    }
                } else {
                    notifications("No se pudo conectar con la base de datos, intente de nuevo")
                }
            }
        }
    }

    private fun llenarLista(listaIdsA: ArrayList<String>, listaNomsA: ArrayList<String>, listaIds: ArrayList<TextView>,
        listaNoms: ArrayList<TextView>, avanzar: Boolean) {
        var indice = 0
        if (!avanzar){
            if(listaIdsA.size>=8) {
                for (id in listaIds) {
                    id.text = listaIdsA[indice]
                    listaNoms[indice].text = listaNomsA[indice]
                    indice++
                }
            }
            else{
                for(id in listaIdsA){
                    listaIds[indice].text = id
                    listaNoms[indice].text = listaNomsA[indice]
                    indice++
                }
            }
        }
        else{
            if (listaIdsA.size>8){
                var nuevoInd:Int = obtenerIndiceActual(listaIdsA, listaIds)
                var ind = 0
                limpiarLista(listaIds, listaNoms)
                val restantes = (listaIdsA.size - (nuevoInd+1))

                if(restantes >=8){
                    for(id in listaIds){
                        id.text = listaIdsA[nuevoInd]
                        listaNoms[ind].text = listaNomsA[nuevoInd]
                        ind++
                        nuevoInd++
                    }
                }
                else{
                    nuevoInd+=1
                    for(i in 0 until restantes){
                        listaIds[ind].text = listaIdsA[nuevoInd]
                        listaNoms[ind].text = listaNomsA[nuevoInd]
                        ind++
                        nuevoInd++
                    }
                }

            }
        }
    }

    private fun limpiarLista(listaIds: ArrayList<TextView>, listaNoms: ArrayList<TextView>) {
        var indice = 0
        for(elemento in listaIds){
            elemento.text = ""
            listaNoms[indice].text = ""
            indice ++
        }
    }

    private fun obtenerIndiceActual(listaIdsA: ArrayList<String>, listaIds: ArrayList<TextView>): Int {
        var nuevoInd = 0
        for(id in listaIdsA){
            if(listaIds[7].text.equals(id)){
                nuevoInd = listaIdsA.indexOf(id)
                break
            }
        }
        return nuevoInd
    }

    private fun notifications(notification: String) {
        Toast.makeText(activity!!, notification, Toast.LENGTH_LONG).show()
    }

    private fun enviarDatos(cedula:TextView){
        infoProfesor(cedula.text.toString())
    }

    private fun infoProfesor(cedula: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getInfoProfesor(cedula)

            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val profes = call.body()
                    if (profes != null) {
                        for (profe in profes) {
                            val ced = profe.get("cedula").toString().replace("\"", "")
                            val nombre = profe.get("nombre").toString().replace("\"", "")
                            val apellidos = profe.get("apellido").toString().replace("\"", "")
                            val correo = profe.get("correo").toString().replace("\"", "")
                            val calificacionPromedio = profe.get("calificacion").toString()
                            comunicador.enviarDatosDocente(ced, "$nombre $apellidos", correo, calificacionPromedio)
                        }
                    }
                } else {
                    print("Error! Conexion con el API Fallida")
                }
            }
        }
    }


}