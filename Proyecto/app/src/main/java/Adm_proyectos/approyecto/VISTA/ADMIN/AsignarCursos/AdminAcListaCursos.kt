package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosAdmin
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ac_lista_cursos.*
import kotlinx.android.synthetic.main.admin_ac_lista_cursos.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminAcListaCursos : Fragment() {

    private lateinit var comunicador: DatosAdmin
    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_lista_cursos, container, false)
        comunicador = activity as DatosAdmin
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaIds = listOf<TextView>(view.idAc1, view.idAc2, view.idAc3, view.idAc4,
            view.idAc5, view.idAc6, view.idAc7, view.idAc8)
        val listaNoms = listOf<TextView>(view.nombreAc1, view.nombreAc2, view.nombreAc3, view.nombreAc4,
            view.nombreAc5, view.nombreAc6, view.nombreAc7, view.nombreAc8)

        obtenerLista(listaIds, listaNoms, false)

        avanzar.setOnClickListener{
            obtenerLista(listaIds, listaNoms, true)
        }

        view.columna1.setOnClickListener(){
            enviarDatos(view.idAc1)
        }

        view.columna2.setOnClickListener(){
            enviarDatos(view.idAc2)
        }

        view.columna3.setOnClickListener(){
            enviarDatos(view.idAc3)
        }

        view.columna4.setOnClickListener(){
            enviarDatos(view.idAc4)
        }

        view.columna5.setOnClickListener(){
            enviarDatos(view.idAc5)
        }

        view.columna6.setOnClickListener(){
            enviarDatos(view.idAc6)
        }

        view.columna7.setOnClickListener(){
            enviarDatos(view.idAc7)
        }

        view.columna8.setOnClickListener(){
            enviarDatos(view.idAc8)
        }
    }

    private fun obtenerLista(listaIds: List<TextView>, listaNoms: List<TextView>, avanzar: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosAdmin()
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val cursos = call.body()
                    val listaIdsA = ArrayList<String>()
                    val listaNomsA = ArrayList<String>()
                    if (cursos != null) {
                        for (curso in cursos) {
                            listaIdsA.add(curso.get("codigo").toString().replace("\"", "") + "_" +
                                    curso.get("clase").toString().replace("\"", ""))
                            listaNomsA.add(curso.get("nombre").toString().replace("\"", "")) //cambiar por nombre
                        }
                        llenarTabla(listaIdsA, listaNomsA, listaIds, listaNoms,avanzar)
                    }
                } else {
                    controller.notificacion("Error al conectar con la base de datos", activity!!)
                }
            }
        }
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

    private fun cursoInfo(codigoCurso: String, gradoCurso: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursoInfo(codigoCurso, gradoCurso)

            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val cursos = call.body()
                    if (cursos != null) {
                        for (curso in cursos) {
                            val id = curso.get("codigo").toString().replace("\"", "")
                            val nombre = curso.get("nombre").toString().replace("\"", "")
                            val grado = curso.get("clase").toString().replace("\"", "")
                            val horario = curso.get("diaSemana").toString().replace("\"", "")+
                                    " de " + curso.get("horaInicio").toString().replace("\"", "") + " a " +
                                    curso.get("horaFin").toString().replace("\"", "")
                            val detalles = AdminAcDetalles()
                            comunicador.enviarDatosCurso(id, nombre, grado, horario, detalles)
                        }
                    }
                } else {
                    controller.notificacion("Error al conectar con la base de datos", activity!!)
                }
            }
        }
    }

    private fun enviarDatos(id:TextView){
        val datos = id.text.split("_")
        val codigo = datos[0]
        val grado = datos[1]
        cursoInfo(codigo, grado)
    }

}