package API

import Adm_proyectos.approyecto.MODELO.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface API_Calls {
    @GET("usuarios/{id}")
    suspend fun getUsusarios(@Path("id") id:String): Response<ArrayList<Usuario>>
}