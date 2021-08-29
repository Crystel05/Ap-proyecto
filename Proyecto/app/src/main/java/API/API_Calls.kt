package API

import Adm_proyectos.approyecto.MODELO.Usuario
import retrofit2.*
import retrofit2.http.GET

interface API_Calls {
    @GET("usuarios/")
    fun getUsusarios(): Call<List<Usuario>>
}