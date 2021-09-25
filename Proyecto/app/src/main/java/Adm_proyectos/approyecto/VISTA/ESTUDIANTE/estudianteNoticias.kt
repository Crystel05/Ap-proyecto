package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import API.RetroInstance
import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.MODELO.Noticia
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.DOCENTE.DocenteDetallesCurso
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosDocente
import Adm_proyectos.approyecto.VISTA.INTERFACES.DatosEstudiante
import android.annotation.SuppressLint
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.admin_ge_crear.*
import kotlinx.android.synthetic.main.estudiante_noticias.*
import kotlinx.android.synthetic.main.estudiante_noticias.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class estudianteNoticias : Fragment() {

    private var controller = ControladorComponentesVista()
    private lateinit var idCurso: String
    private lateinit var grado: String
    private lateinit var comunicador: DatosEstudiante
    private lateinit var comunicador2: DatosDocente
    private lateinit var cedula: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.estudiante_noticias, container, false)
        comunicador = activity as DatosEstudiante
        comunicador2 = activity as DatosDocente
        val datos = arguments?.getStringArray("datosCursoPequeno")
        idCurso = datos?.get(0).toString()
        grado = datos?.get(1).toString()
        val correo = datos?.get(2).toString()
        cedula = correo
        view.idCursoEstudiantes.text = idCurso
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tits = listOf<TextView>(titulo1, titulo2, titulo3)
        val fecs = listOf<TextView>(fecha1, fecha2, fecha3)

        noticias(idCurso, grado, tits, fecs, false, 0)

        siguientesNots.setOnClickListener {
            noticias(idCurso, grado, tits, fecs, true, 0)


        }

        noticia1.setOnClickListener{
            noticias(idCurso, grado, tits, fecs, false, 1)
        }

        noticia2.setOnClickListener{
            noticias(idCurso, grado, tits, fecs, false, 2)
        }

        noticia3.setOnClickListener{
            noticias(idCurso, grado, tits, fecs, false, 3)
        }

        atrasNoticias.setOnClickListener {
            cursoInfo(idCurso, grado)
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
                            val detalles = DocenteDetallesCurso()
                            comunicador2.enviarDatosCurso(id, nombre, grado, horario, detalles, cedula)

                        }
                    }
                } else {
                    controller.notificacion("Error al conectar con la base de datos", activity!!)
                }
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun noticias(codigo: String, grado: String, titulos: List<TextView>, fechas: List<TextView>, avanzar: Boolean, buscar:Int){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getNoticias(codigo, grado)
            print(call)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val noticias = call.body()
                    val noticiasCont = ArrayList<Noticia>()
                    if (noticias != null) {
                        for (noticia in noticias) {
                            val titulo = noticia.get("titulo").toString().replace("\"", "")
                            val contenido = noticia.get("descripcion").toString().replace("\"", "")
                            var fecha = noticia.get("fecha").toString().replace("\"", "")
                            fecha = fecha.split("T")[0]
                            val noticia = Noticia(titulo, contenido, fecha)
                            noticiasCont.add(noticia)
                        }
                        when (buscar) {
                            0 -> llenarTablaAux(noticiasCont, titulos, fechas, avanzar)
                            1 -> comunicador.enviarDatosNoticias(noticiasCont[0])
                            2 -> comunicador.enviarDatosNoticias(noticiasCont[2])
                            3 -> comunicador.enviarDatosNoticias(noticiasCont[2])
                        }
                    }
                } else {
                    controller.notificacion("Error al conectar con la base de datos", activity!!)
                }
            }
        }
    }

    private fun llenarTablaAux(noticiasCont: java.util.ArrayList<Noticia>, titulos: List<TextView>, fechas: List<TextView>, avanzar: Boolean) {
        val titulosA = ArrayList<String>()
        val fechasA = ArrayList<String>()

        for(ind in noticiasCont){
            titulosA.add(ind.titulo)
            fechasA.add(ind.fecha)
        }

        llenarTabla(titulosA, fechasA, titulos, fechas, avanzar)

    }

    private fun llenarTabla(listaIdsA: ArrayList<String>, listaNomsA: ArrayList<String>,
                            listaIds: List<TextView>, listaNoms: List<TextView>, avanzar:Boolean) {
        var indice = 0
        if (!avanzar){
            if (listaIdsA.size>=3) {
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
                if (indice < 3){
                    when (indice) {
                        0 -> {
                            noticia1.visibility = View.INVISIBLE
                            noticia2.visibility = View.INVISIBLE
                            noticia3.visibility = View.INVISIBLE
                        }
                        1 -> {
                            noticia2.visibility = View.INVISIBLE
                            noticia3.visibility = View.INVISIBLE
                        }
                        2 -> {
                            noticia3.visibility = View.INVISIBLE
                        }
                    }
                }
            }
        }
        else{
            if (listaIdsA.size>3){
                var nuevoInd:Int = obtenerIndiceActual(listaIdsA, listaIds)
                var ind = 0
                limpiarLista(listaIds, listaNoms)
                val restantes = (listaIdsA.size - (nuevoInd+1))

                if(restantes >=2){
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
            if(listaIds[2].text.equals(id)){
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
}