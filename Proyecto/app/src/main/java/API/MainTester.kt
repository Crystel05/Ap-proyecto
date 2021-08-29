package API

import Adm_proyectos.approyecto.MODELO.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainTester {

    fun test() {

        RetroInstance.api.getUsusarios().enqueue(object : Callback<List<Usuario>>{
            //val usu  List<Usuario>(3)

            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {

                val usu = response.body()

                print(usu?.get(0)?.nombre)
                // pr = usu?.get(0)?.nombre
            }

            override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
                t?.printStackTrace()
                print("Error, conexion con API fallida")
            }
        })
    }
}

fun main(){
    print("Hola Mundo")

    val tester: MainTester = MainTester()
    val firstTodo = tester.test()

}