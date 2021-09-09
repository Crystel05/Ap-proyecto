package Adm_proyectos.approyecto.CONTROLADOR

import API.RetroInstance
import Adm_proyectos.approyecto.R
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ControladorComponentesVista {

//    fun prueba(act: FragmentActivity, query: String, text: TextView){
//        CoroutineScope(Dispatchers.IO).launch{
//            val call = RetroInstance.api.getUsusarios(query)
//            val miUsuario = call.body()
//            act.runOnUiThread{
//                if(call.isSuccessful){
//                    text.text = miUsuario?.get(0)?.nombre.toString()
////                    print(miUsuario?.get(0)?.nombre)
//                }else{
//                    print("Error! Conexion con el API Fallida")
//                }
//            }
//
//        }
//    }

    fun cambiarFragment(fragment: Fragment, contenedor: FrameLayout, activity: FragmentActivity){
        val transacion = (activity).supportFragmentManager.beginTransaction()
        transacion.replace(contenedor.id, fragment)
        transacion.commit()
    }
}