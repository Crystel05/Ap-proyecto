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
import kotlinx.android.synthetic.main.admin_gc_modificar_curso.*
import kotlinx.android.synthetic.main.admin_gc_modificar_curso.view.*
import kotlinx.android.synthetic.main.docente_lista_cursos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class admin_gc_modificarCurso : Fragment() {

    private var id: String = ""
    private var grado: String = ""
    private val controller = ControladorComponentesVista()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_gc_modificar_curso, container, false)
        //val id = arguments?.getString("ID")
        val grados = ArrayList<String>()
        grados.add("prepa")
        grados.add("1")
        grados.add("2")
        grados.add("3")
        grados.add("4")
        grados.add("5")
        grados.add("6")
        grados.add("7")
        grados.add("8")
        grados.add("9")
        grados.add("10")
        grados.add("11")

        val arrayDatos = arguments?.getStringArray("datosCursoNuevoModificar")
        id = arrayDatos?.get(0).toString()
        val nombre = arrayDatos?.get(1)
        grado = arrayDatos?.get(2).toString()
        val horario = arrayDatos?.get(3)?.split(" ")
        view.idModificarCurso.setText(id)
        view.idCursoModificar.text = id
        view.nombreModificarCurso.setText(nombre)

        view.horaInicioModificarCurso.setText(horario?.get(2))
        view.horafinModificarCurso.setText(horario?.get(4))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArrayAdapter.createFromResource(activity!!, R.array.ListaGrados, R.layout.support_simple_spinner_dropdown_item).also {
            adapter -> adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            gradoModificarCurso.adapter = adapter
        }
        ArrayAdapter.createFromResource(activity!!, R.array.diasSemana, R.layout.support_simple_spinner_dropdown_item).also {
         adapter -> adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
         diaModificarCurso.adapter = adapter
        }
        guardarCursoGCM.setOnClickListener(){
            notifications("${idModificarCurso.text} ${nombreModificarCurso.text} ${gradoModificarCurso.selectedItem} " +
                    "${diaModificarCurso.selectedItem} " +
                    "${horaInicioModificarCurso.text} ${horafinModificarCurso.text} Id viejo: $id grado viejo: $grado")

            updateCurso(id, grado, idModificarCurso.text.toString(), nombreModificarCurso.text.toString(), gradoModificarCurso.selectedItem.toString(),
                diaModificarCurso.selectedItem.toString(), horaInicioModificarCurso.text.toString(), horafinModificarCurso.text.toString())
        }
    }

    private fun notifications(notifiacion: String){
        Toast.makeText(activity!!, notifiacion, Toast.LENGTH_LONG).show()
    }

    private fun updateCurso(codigoViejo: String, gradoViejo: String, codigo: String, nombre: String, gradoId: String, diaSemana: String, horaInicio: String, horaFin : String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.updateCurso(codigoViejo, gradoViejo, codigo, nombre, gradoId, diaSemana, horaInicio, horaFin)
            activity!!.runOnUiThread {
                print(call)
                if (call.isSuccessful) {
                    val resultados = call.body()
                    if (resultados != null) {
                        val resultado = resultados?.get(0)?.get("actualizarcurso")
                        if (resultado.asInt == 0) {
                            notifications("Curso modificado con éxito!!")
                            actualizarFinalizado()
                        }else{
                            notifications("No se pudo actualizar el curso, inten de nuevo")
                        }
                    }
                    else{
                        notifications("No se pudo actualizar alguna de las características del curso, intente de nuevo")
                    }
                } else {
                    notifications("Error al conectar con la base de datos, intente de nuevo")
                }
            }
        }
    }

    private fun actualizarFinalizado() {
        val listaCursos = admin_gc_listaCursos()
        controller.cambiarFragment(listaCursos, R.id.contenedor, activity!!)
    }


}