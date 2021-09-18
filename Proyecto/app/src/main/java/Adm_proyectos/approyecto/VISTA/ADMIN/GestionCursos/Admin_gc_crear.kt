package Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN

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
import kotlinx.android.synthetic.main.admin_gc_crear.*
import kotlinx.android.synthetic.main.admin_gc_crear.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class admin_gc_crear : Fragment() {

    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_crear, container, false)
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
            view.gradoCrearCurso.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            context!!,
            R.array.diasSemana,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.diaCrearCurso.adapter = adapter
        }

        insertadoExitoso(false)

        agregarCursoGC.setOnClickListener() {
            agregar()
        }

    }

    private fun agregar() {
        if (idCrearCurso.text.isNotEmpty() && nombreCrearCurso.text.isNotEmpty() && horaInicioCrearCurso.text.isNotEmpty() && horafinCrearCurso.text.isNotEmpty()) {
            val formatoHora = "[0-9]{2}:[0-9]{2}(:[0-9]{2})?"
            val pattern = Pattern.compile(formatoHora)
            val matcher = pattern.matcher(horaInicioCrearCurso.text.toString())
            val matcher2 = pattern.matcher(horafinCrearCurso.text.toString())
            if (matcher.find() && matcher2.find()) {
                insertarCurso(
                    idCrearCurso.text.toString(),
                    nombreCrearCurso.text.toString(),
                    gradoCrearCurso.selectedItem.toString(),
                    diaCrearCurso.selectedItem.toString(),
                    horaInicioCrearCurso.text.toString(),
                    horafinCrearCurso.text.toString()
                )
            } else {
                notificacions("Formato de hora incorrecto, intente con: 14:00:00")
            }
        } else {
            notificacions("Existen campos sin llenar")
        }
    }

    fun insertarCurso(codigo: String, nombre: String, gradoId: String, diaSemana: String, horaInicio: String, horaFin: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarCurso(codigo, nombre, gradoId, diaSemana, horaInicio, horaFin)
            activity!!.runOnUiThread {
                if (call.isSuccessful) {
                    val resultados = call.body()
                    if (resultados != null) {
                        val resultado = resultados?.get(0)?.get("insertarcurso")
                        if (resultado.asInt == 0) {
                            notificacions("Curso agregado con éxito!!")
                            insertadoExitoso(true)
                        }else{
                            notificacions("Hubo un error al gurdar el curso, intente de nuevo")
                        }
                    }
                    else{
                        notificacions("Error al insertar detalles, intente de nuevo")
                    }
                } else {
                    notificacions("Error al conectar con la base de datos, intente de nuevo")
                }
            }
        }
    }

    private fun insertadoExitoso(insertar:Boolean) {
        idCrearCurso.text.clear()
        nombreCrearCurso.text.clear()
        horaInicioCrearCurso.text.clear()
        horafinCrearCurso.text.clear()
        if (insertar) {
            val listaCursos = admin_gc_listaCursos()
            controller.cambiarFragment(listaCursos, R.id.contenedor, activity!!)
        }
    }

    private fun notificacions(notificacion: String) {
        Toast.makeText(activity!!, notificacion, Toast.LENGTH_LONG).show()
    }

}