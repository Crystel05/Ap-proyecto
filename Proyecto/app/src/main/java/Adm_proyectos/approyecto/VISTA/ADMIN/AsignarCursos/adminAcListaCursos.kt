package Adm_proyectos.approyecto.VISTA.ADMIN.AsignarCursos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.INTERFACES.Comunicador
import kotlinx.android.synthetic.main.admin_ac_lista_cursos.view.*
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna1
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna2
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna3
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna4
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna5
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna6
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna7
import kotlinx.android.synthetic.main.admin_gc_lista_cursos.view.columna8
class adminAcListaCursos : Fragment() {

    private lateinit var comunicador: Comunicador

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.admin_ac_lista_cursos, container, false)
        comunicador = activity as Comunicador
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.columna1.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc1.text.toString(), view.nombreAc1.text.toString())
        }

        view.columna2.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc2.text.toString(), view.nombreAc2.text.toString())
        }

        view.columna3.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc3.text.toString(), view.nombreAc3.text.toString())
        }

        view.columna4.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc4.text.toString(), view.nombreAc4.text.toString())
        }

        view.columna5.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc5.text.toString(), view.nombreAc5.text.toString())
        }

        view.columna6.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc6.text.toString(), view.nombreAc6.text.toString())
        }

        view.columna7.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc7.text.toString(), view.nombreAc7.text.toString())
        }

        view.columna8.setOnClickListener(){
            comunicador.enviarDatosCursoAc(view.idAc8.text.toString(), view.nombreAc8.text.toString())
        }
    }

}