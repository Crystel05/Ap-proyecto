package Adm_proyectos.approyecto.VISTA.ADMIN.GestionEstudiantes

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorAdmin
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_detalles.view.*
import kotlinx.android.synthetic.main.admin_ge_lista_estudiantes.*
import kotlinx.android.synthetic.main.admin_ge_lista_estudiantes.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adminGeListaEstudiantes : Fragment() {

    private lateinit var comunicador: Comunicador
    private val controller = ControladorComponentesVista()
    private val controllerAdmin = ControladorAdmin()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ge_lista_estudiantes, container, false)
        comunicador = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaGrados = listOf<TextView>(view.grado1, view.grado2, view.grado3, view.grado4,
            view.grado5, view.grado6, view.grado7, view.grado8)
        val listaNombres = listOf<TextView>(view.nomE1, view.nomE2, view.nomE3, view.nomE4,
            view.nomE5, view.nomE6, view.nomE7, view.nomE8)

        obtenerListaEstudiantes(listaNombres, listaGrados, false)
        view.agregarNuevoEstudiante.setOnClickListener() {
            val crearEstudiante = adminGeCrear()
            controller.cambiarFragment(crearEstudiante, R.id.contenedor, activity!!)
        }
        flechaAd.setOnClickListener{
            obtenerListaEstudiantes(listaNombres, listaGrados,true)
        }

        view.colum1.setOnClickListener(){
            enviarDatos(view.grado1)
        }

        view.colum2.setOnClickListener(){
            enviarDatos(view.grado2)
        }

        view.colum3.setOnClickListener(){
            enviarDatos(view.grado3)
        }

        view.colum4.setOnClickListener(){
            enviarDatos(view.grado4)
        }

        view.colum5.setOnClickListener(){
            enviarDatos(view.grado5)
        }

        view.colum6.setOnClickListener(){
            enviarDatos(view.grado6)
        }

        view.colum7.setOnClickListener(){
            enviarDatos(view.grado7)
        }

        view.colum8.setOnClickListener(){
            enviarDatos(view.grado8)
        }
    }

    private fun obtenerListaEstudiantes(listaIds: List<TextView>, listaNoms: List<TextView>, avanzar: Boolean){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getEstudiantes()

            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val estudiantes = call.body()
                    val listaClaseA = ArrayList<String>()
                    val listaNomsA = ArrayList<String>()
                    if (estudiantes != null) {
                        for (estudiante in estudiantes) {
                            listaNomsA.add(estudiante.get("nombre").toString().replace("\"", "") + " " +
                                    estudiante.get("apellido").toString().replace("\"", ""))
                            listaClaseA.add(estudiante.get("clase").toString().replace("\"", ""))
                        }
                        llenarTabla(listaClaseA, listaNomsA, listaIds, listaNoms, avanzar)
                    }
                } else {
                    notificaciones("Error al conectar con la base de datos")
                }
            }
        }
    }

    private fun notificaciones(notificacion: String?) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }

    private fun llenarTabla(listaIdsA: ArrayList<String>, listaNomsA: ArrayList<String>,
                            listaIds: List<TextView>, listaNoms: List<TextView>, avanzar:Boolean) {
        var indice = 0
        if (!avanzar){
            if (listaIdsA.size>=8) {
                for (id in listaIds) {
                    id.text = listaIdsA[indice]
                    listaNoms[indice].text = listaNomsA[indice]
                    indice++
                }
            }
            else {
                for (id in listaIdsA) {
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

    private fun obtenerIndiceActual(listaIdsA: ArrayList<String>, listaIds: List<TextView>): Int {
        var nuevoInd = 0
        for(id in listaIdsA){
            if(listaIds[7].text.equals(id)){
                nuevoInd = listaIdsA.indexOf(id)
                break
            }
        }
        return nuevoInd
    }

    private fun limpiarLista(listaIds: List<TextView>, listaNoms: List<TextView>) {
        var indice = 0
        for(elemento in listaIds){
            elemento.text = ""
            listaNoms[indice].text = ""
            indice ++
        }
    }

    private fun enviarDatos(nombre: TextView){
        val datos = nombre.text.split(" ")
        val nombre = datos[0]
        val apellido = datos[1]
        infoEstudiante(nombre, apellido)
    }

    fun infoEstudiante(nombre: String, apellido: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getInfoEstudiante(nombre, apellido)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val estudiantes = call.body()
                    if (estudiantes != null) {
                        for (estudiante in estudiantes) {
                            val nomb = estudiante.get("nombre").toString().replace("\"", "")
                            val ced = estudiante.get("cedula").toString().replace("\"", "")
                            val grado = estudiante.get("clase").toString().replace("\"", "")
                            comunicador.enviarDatosEstudiante(nomb, ced, grado)
                        }

                    }
                } else {
                    notificaciones("Error al conectar con la base de datos")
                }
            }
        }
    }

    private fun notificacions(notificacion: String) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }
}