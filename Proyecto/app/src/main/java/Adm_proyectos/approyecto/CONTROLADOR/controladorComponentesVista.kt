package Adm_proyectos.approyecto.CONTROLADOR

import API.RetroInstance
import android.support.v4.app.FragmentActivity
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class controladorComponentesVista {

    fun prueba(act: FragmentActivity, query: String, text: TextView){
        CoroutineScope(Dispatchers.IO).launch{
            val call = RetroInstance.api.getUsusarios(query)
            val miUsuario = call.body()
            act.runOnUiThread{
                if(call.isSuccessful){
                    text.text = miUsuario?.get(0)?.nombre.toString()
//                    print(miUsuario?.get(0)?.nombre)
                }else{
                    print("Error! Conexion con el API Fallida")
                }
            }

        }
    }
}