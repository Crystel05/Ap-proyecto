package API

import Adm_proyectos.approyecto.MODELO.Curso
import Adm_proyectos.approyecto.MODELO.Usuario
import com.google.gson.JsonObject
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*
import java.sql.Time


interface API_Calls {
    @GET("usuarios/{id}")
    suspend fun getUsusario(@Path("id") id:String): Response<ArrayList<JsonObject>>

    @GET("usuarios")
    suspend fun getUsusarios(): Response<ArrayList<JsonObject>>

    @GET("logIn/{correo}")
    suspend fun getLogin(@Path("correo") correo:String): Response<ArrayList<JsonObject>>

    @GET("cursos")
    suspend fun getCursosAdmin(): Response<ArrayList<JsonObject>>

    @GET("cursos/estudiante/{estCorreo}")
    suspend fun getCursosEstudiante(@Path("estCorreo") correo:String): Response<ArrayList<JsonObject>>

    @GET("cursos/profesor/{profCorreo}")
    suspend fun getCursosProfesor(@Path("profCorreo") correo:String): Response<ArrayList<JsonObject>>

    @GET("cursos/info/{cod}/{clase}")
    suspend fun getCursoInfo(@Path("cod") codigoCurso:String, @Path("clase") gradoCurso: String): Response<ArrayList<JsonObject>>

    @GET("profesores")
    suspend fun getProfesores(): Response<ArrayList<JsonObject>>

    @GET("gradoId/{numGrad}")
    suspend fun getCursoInfo(@Path("numGrad") codigoCurso:String): Response<ArrayList<JsonObject>>

    @GET("profesores/{ced}")
    suspend fun getInfoProfesor(@Path("ced") cedula:String): Response<ArrayList<JsonObject>>

    @GET("estudiantes")
    suspend fun getEstudiantes(): Response<ArrayList<JsonObject>>

    @GET("estudiantes/{nom}/{apel}")
    suspend fun getInfoEstudiante(@Path("nom") nombre:String, @Path("apel") apellido:String): Response<ArrayList<JsonObject>>

//    @POST("/nuevoCurso")
//    suspend fun insertarCurso(@Query("codigo") codigo : String,
//                              @Query("nombre") nombre:String,
//                              @Query("gradoId") gradoId:String,
//                              @Query("diaSemana") diaSemana:String,
//                              @Query("horaInicio") horaInicio:String,
//                              @Query("horaFin") horaFin:String, ) : Response<Int>

    @GET("nuevoCurso/{codigo}/{nombre}/{gradoId}/{diaSemana}/{horaInicio}/{horaFin}")
    suspend fun insertarCurso(@Path("codigo") codigo : String,
                              @Path("nombre") nombre:String,
                              @Path("gradoId") gradoId:String,
                              @Path("diaSemana") diaSemana:String,
                              @Path("horaInicio") horaInicio:String,
                              @Path("horaFin") horaFin:String) : Response<ArrayList<JsonObject>>

    @GET("nuevoDocente/{cedula}/{nombre}/{correo}/{contra}/{apellido}")
    suspend fun insertarProfesor(@Path("cedula") cedula : String,
                                  @Path("nombre") nombre:String,
                                  @Path("correo") correo:String,
                                  @Path("contra") contra:String,
                                  @Path("apellido") apellido:String) : Response<ArrayList<JsonObject>>

    @GET("nuevoAlumno/{cedula}/{nombre}/{correo}/{contra}/{apellido}/{grado}")
    suspend fun insertarEstudiante(@Path("cedula") cedula : String,
                                     @Path("nombre") nombre:String,
                                     @Path("correo") correo:String,
                                     @Path("contra") contra:String,
                                     @Path("apellido") apellido:String,
                                     @Path("grado") grado:String) : Response<ArrayList<JsonObject>>

//    @PUT("updateCurso")
//    suspend fun updateCurso(@Query("codviejo") codviejo:String,
//                            @Query("gradviejo") gradviejo:String,
//                            @Query("codigo") codigo : String,
//                            @Query("nombre") nombre:String,
//                            @Query("gradoId") gradoId:String,
//                            @Query("diaSemana") diaSemana:String,
//                            @Query("horaInicio") horaInicio:String,
//                            @Query("horaFin") horaFin:String, ) : Response<ArrayList<JsonObject>>

    @GET("updateCurso/{codviejo}/{gradviejo}/{nombre}/{codigo}/{diaSemana}/{horaInicio}/{horaFin}/{gradoId}")
    suspend fun updateCurso(@Path("codviejo") codviejo:String,
                            @Path("gradviejo") gradviejo:String,
                            @Path("codigo") codigo : String,
                            @Path("nombre") nombre:String,
                            @Path("gradoId") gradoId:String,
                            @Path("diaSemana") diaSemana:String,
                            @Path("horaInicio") horaInicio:String,
                            @Path("horaFin") horaFin:String, ) : Response<ArrayList<JsonObject>>

    @GET("updateDocente/{cedvieja}/{cedula}/{nombre}/{correo}/{contra}/{apellido}")
    suspend fun updateProfesor( @Path("cedvieja") cedvieja : String,
                                @Path("cedula") cedula : String,
                                 @Path("nombre") nombre:String,
                                 @Path("correo") correo:String,
                                 @Path("contra") contra:String,
                                 @Path("apellido") apellido:String) : Response<ArrayList<JsonObject>>

    //                updateAlumno/:nombviejo/:apeviejo/:cedula/:nombre/:correo/:contra/:apellido/:grado
    @GET("updateAlumno/{cedvieja}/{cedula}/{nombre}/{correo}/{contra}/{apellido}/{grado}")
    suspend fun updateEstudiante(@Path("cedvieja") cedvieja : String,
                                 @Path("cedula") cedula : String,
                                   @Path("nombre") nombre:String,
                                   @Path("correo") correo:String,
                                   @Path("contra") contra:String,
                                   @Path("apellido") apellido:String,
                                   @Path("grado") grado:String) : Response<ArrayList<JsonObject>>

    @GET("asignarProfe/{cedula}/{codigo}/{grado}")
    suspend fun asignarProfesor(@Path("cedula") cedula : String,
                                 @Path("codigo") codigo:String,
                                 @Path("grado") grado:String) : Response<ArrayList<JsonObject>>

    @GET("asignarAlumno/{nombre}/{apellido}/{codigo}/{grado}")
    suspend fun asignarEstudiante(@Path("nombre") nombre : String,
                                @Path("apellido") apellido: String,
                                @Path("codigo") codigo: String,
                                @Path("grado") grado: String) : Response<ArrayList<JsonObject>>


















}