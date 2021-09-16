package Adm_proyectos.approyecto.CONTROLADOR

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

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

    fun cambiarFragment(fragment: Fragment, id:Int, activity: FragmentActivity){
        val transacion = (activity).supportFragmentManager.beginTransaction()
        transacion.replace(id, fragment)
        transacion.commit()
    }
}