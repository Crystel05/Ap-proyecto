package API

import Adm_proyectos.approyecto.MODELO.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainTester {
}

fun main(){
    print("Hola Mundo")

    RetroInstance.api.getUsusarios().enqueue(object : Callback<List<Usuario>>{
        override fun onResponse(call: Call<List<Usuario>>?, response: Response<List<Usuario>>?) {

            val usu = response?.body()
            print(usu)
        }

        override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
            print("Error, conexion con API fallida")
        }
    })

    print("Fin del programa")
}