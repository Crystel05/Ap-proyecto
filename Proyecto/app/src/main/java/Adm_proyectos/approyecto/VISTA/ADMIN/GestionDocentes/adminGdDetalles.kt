package Adm_proyectos.approyecto.VISTA.ADMIN.GestionDocentes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import android.app.Dialog
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.ImageView
import kotlinx.android.synthetic.main.admin_gd_detalles.view.*
import kotlinx.android.synthetic.main.admin_gd_lista_docentes.view.*
import kotlinx.android.synthetic.main.pop_up_lista_cursos.*

class adminGdDetalles : Fragment() {

//    private lateinit var popUp : Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        popUp = Dialog(activity!!)
        val view = inflater.inflate(R.layout.admin_gd_detalles, container, false)
        val array = arguments?.getStringArray("datosDocente")
        val ced = array?.get(0)
        val nomD = array?.get(1)
        view.cedulaD.text = ced
        view.nombreD.text = nomD
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.verListaDocente.setOnClickListener(){
//            popUp()
//        }
    }

//    fun popUp(){
//
//        popUp.setContentView(R.layout.pop_up_lista_cursos)
////        val cerrar = popUp.findViewById<ImageView>(R.id.cerrar)
////        cerrar.setOnClickListener(){
////            popUp.dismiss()
////        }
//        popUp.show()
//    }


}