package API

import Adm_proyectos.approyecto.MODELO.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainTester {

    fun buscarUsuario(query: String) {

        CoroutineScope(Dispatchers.IO).launch{
            val call = RetroInstance.api.getUsusarios(query)
            val miUsuario = call.body()
            if(call.isSuccessful){
                print(miUsuario?.get(0)?.nombre)
            }else{
                print("Error! Conexion con el API Fallida")
            }
        }
        
    }


}

fun main(){

    var x = 1
    while(true) {

        if(x==1){
        println("Hola Mundo")
        val tester: MainTester = MainTester()
        val firstTodo = tester.buscarUsuario("1")
        x=2}
    }
}