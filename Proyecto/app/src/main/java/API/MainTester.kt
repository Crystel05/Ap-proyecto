package API

import Adm_proyectos.approyecto.MODELO.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainTester {
}

fun main(){
    print("Hola Mundo")

    val retro: Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val servicio = retro.create<API_Calls>(API_Calls::class.java)

    servicio.getUsusarios().enqueue(object : Callback<List<Usuario>>{
        override fun onResponse(call: Call<List<Usuario>>?, response: Response<List<Usuario>>?) {

            val usu = response?.body()
            print(usu)
        }

        override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
            t?.printStackTrace()
            print("Error, conexion con API fallida")
        }
    })

    print("Fin del programa")
}