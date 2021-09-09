package Adm_proyectos.approyecto.VISTA.ESTUDIANTE

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import kotlinx.android.synthetic.main._log_in.*
import kotlinx.android.synthetic.main.estudiante_noticias.*

class estudianteNoticias : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.estudiante_noticias, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noticia1.setOnClickListener(){
            popUp()
        }

        noticia2.setOnClickListener(){
            popUp()
        }

        noticia3.setOnClickListener(){
            popUp()
        }

    }

    fun popUp(){
        val dialogo = popUpNoticia()
        dialogo.show(activity!!.supportFragmentManager, "NoticiasEstudiante")
    }
}