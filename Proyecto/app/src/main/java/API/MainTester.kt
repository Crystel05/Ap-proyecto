package API

import Adm_proyectos.approyecto.MODELO.Usuario
import kotlinx.coroutines.*


class MainTester {

    fun buscarUsuario(query: String){
//    fun buscarUsuario(act: FragmentActivity, query: String){
            CoroutineScope(Dispatchers.IO).launch {
                val call = RetroInstance.api.getUsusario(query)
//                act.runOnUiThread { runOnUi
                    if (call.isSuccessful) {
//                        El body viene en formato Json
                        val miUsuario = call.body()?.get(0)
                        print(miUsuario)
                        print( "\n" + miUsuario?.get("nombre"))
                    } else {
                        print("Error! Conexion con el API Fallida")
                    }
//                } end runOnUi
            }
        }

    fun buscarUsuarios(){
//    fun buscarUsuarios(act: FragmentActivity){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getUsusarios()

//            act.runOnUiThread { runOnUi
                if (call.isSuccessful) {
                    val usuarios = call.body()
                    if (usuarios != null) {
                        for (usuario in usuarios) {
                            print(usuario)
                            print("\n" + usuario?.get("correo"))
                            print("\n")
//                            user.nombre = usuario?.nombre.toString()
//                            user.apellidos = usuario?.apellidos.toString()
//                            user.correo = usuario?.correo.toString()
//                            user.cedula = usuario?.cedula.toString()
//                            user.contrasenna = usuario?.contrasenna.toString()
//                            print(user.correo + "\n")
//
//                            prueba.text = user.nombre
                        }
                    }
                } else {
                    print("Error! Conexion con el API Fallida")
                }
//            } end runOnUi
        }
    }

    fun login(query: String){
//    fun login(act : FragmentActivity , query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getLogin(query)

//            act.runOnUiThread {  runOnUi
                if (call.isSuccessful) {
//                    Obtiene el primer elemento de la lista (json) y la contrasenna del Json
                    val miContrasenna = call.body()?.get(0)?.get("contrasenna")
                    print(miContrasenna)
                } else {
                    print("Error! Conexion con el API Fallida")
                }
//            } end runOnUi
        }
    } //done

    fun cursosAdmin(){
//    fun cursosAdmin(act: FragmentActivity){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosAdmin()
            print(call)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val cursos = call.body()
                print(cursos)
                if (cursos != null) {
                    for (curso in cursos) {
                        print(curso?.get("codigo").toString() + curso?.get("clase").toString() + curso?.get("nombre").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

    fun cursosEstudiante(query: String){
//    fun cursosEstudiante(act: FragmentActivity, query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosEstudiante(query)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val cursos = call.body()
                print(cursos)
                if (cursos != null) {
                    for (curso in cursos) {
                        print(curso?.get("nombre").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun cursosProfesor(query: String){
//    fun cursosProfesor(act: FragmentActivity, query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursosProfesor(query)
            print(call)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val cursos = call.body()
                print(cursos)
                if (cursos != null) {
                    for (curso in cursos) {
                        print(curso?.get("nombre").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

    fun cursoInfo(codigoCurso: String, gradoCurso: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursoInfo(codigoCurso, gradoCurso)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val cursos = call.body()
//                print(cursos)
                if (cursos != null) {
                    for (curso in cursos) {
                        print(curso)
                        print(curso?.get("nombre").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

    //    NO VIENE CORREO EN LA BASE DE DATOS
    fun buscarProfesores(){
//    fun buscarProfesores(act: FragmentActivity){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getProfesores()

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val profesores = call.body()
                if (profesores != null) {
                    for (profe in profesores) {
                        print(profe)
                        print("\n" + profe?.get("correo"))
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }//done

    fun gradoId(numeroGrado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getCursoInfo(numeroGrado)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val grados = call.body()
                if (grados != null) {
                    for (grado in grados) {
                        print(grado)
                        print(grado?.get("ID").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun infoProfesor(cedula: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getInfoProfesor(cedula)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val profes = call.body()
                if (profes != null) {
                    for (profe in profes) {
                        print(profe)
                        print("\n" + profe?.get("cedula").toString())
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

    //NO VIENE CORREO
    fun buscarEstudiantes(){
//    fun buscarEstudiantes(act: FragmentActivity){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getEstudiantes()

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val estudiantes = call.body()
                print(estudiantes)
                if (estudiantes != null) {
                    for (estudiante in estudiantes) {
//                            print(estudiante)
                        print("\n" + estudiante?.get("nombre"))

                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

    fun infoEstudiante(nombre: String, apellido: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getInfoEstudiante(nombre, apellido)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val estudiantes = call.body()
                if (estudiantes != null) {
                    for (estudiante in estudiantes) {
                        print(estudiante)
                        print("\n" + estudiante?.get("cedula").toString())
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun insertarCurso(codigo: String, nombre: String, gradoId: String, diaSemana: String, horaInicio: String, horaFin: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarCurso(codigo, nombre, gradoId, diaSemana, horaInicio, horaFin)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    val resultado = resultados?.get(0)?.get("insertarcurso")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("insertarcurso"))
                        }
                    }else{
                        print("Error al insertar el curso.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } //done

//    VALIDAR QUE NO SE REPITA ID
    fun insertarProfesor(cedula: String, nombre: String, correo: String, contra: String, apellido: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarProfesor(cedula, nombre, correo, contra, apellido)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("insertardocente")
                    if (resultado.asInt == 0) {

                        for (resultado in resultados) {
                            print(resultado.get("insertardocente"))
                        }
                    }else{
                        print("Error al insertar el profesor.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        } // done
    }

    //    VALIDAR QUE NO SE REPITA ID Usuario
    fun insertarEstudiante(cedula: String, nombre: String, correo: String, contra: String, apellido: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarEstudiante(cedula, nombre, correo, contra, apellido, grado)
//            act.runOnUiThread { runOnUi
//            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("insertaralumno")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("insertaralumno"))
                        }
                    }else{
                        print("Error al insertar el estudiante.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    } // done

    fun updateCurso(codigoViejo: String, gradoViejo: String, codigo: String, nombre: String, gradoId: String, diaSemana: String, horaInicio: String, horaFin : String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.updateCurso(codigoViejo, gradoViejo, codigo, nombre, gradoId, diaSemana, horaInicio, horaFin)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("actualizarcurso")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("actualizarcurso"))
                        }
                    }else{
                        print("Error al actualizar el curso.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun updateProfesor(cedulaVieja: String, cedula: String, nombre: String, correo: String, contra: String, apellido: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.updateProfesor(cedulaVieja, cedula, nombre, correo, contra, apellido)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("actualizardocente")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("actualizardocente"))
                        }
                    }else{
                        print("Error al actualizar el profesor.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }// done

    fun updateEstudiante(nombreViejo: String, apellidoViejo:String ,cedula: String, nombre: String, correo: String, contra: String, apellido: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.updateEstudiante(nombreViejo, apellidoViejo, cedula, nombre, correo, contra, apellido, grado)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("actualizaralumno")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("actualizaralumno"))
                        }
                    }else{
                        print("Error al actualizar el estudiante.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun asignarProfesor(cedula: String, codigo: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.asignarProfesor(cedula, codigo, grado)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("asignarprofe")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("asignarprofe"))
                        }
                    }else{
                        print("Error al asignar el profesor.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun asignarEstudiante(nombre: String, apellido: String, codigo: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.asignarEstudiante(nombre, apellido, codigo, grado)
//            act.runOnUiThread { runOnUi
            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("asignaralumno")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("asignaralumno"))
                        }
                    }else{
                        print("Error al asignar el estudiante.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun buscarEstudiante(cedula: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getBuscarEstudiante(cedula)

//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val estudiantes = call.body()
                if (estudiantes != null) {
                    for (estudiante in estudiantes) {
                        print(estudiante)
                        print("\n" + estudiante?.get("cedula").toString())
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun insertarTarea(codigo: String, clase: String, codigotarea:String, titulo: String, contenido: String, fecha: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarTarea(codigo, clase, codigotarea, titulo, contenido, fecha)
//            act.runOnUiThread { runOnUi
//            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("insertartarea")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("insertartarea"))
                        }
                    }else{
                        print("Error al insertar la tarea.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun insertarNoticia(codigo: String, clase: String, titulo:String, contenido: String, fecha: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarNoticia(codigo, clase, titulo, contenido, fecha)
//            act.runOnUiThread { runOnUi
//            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("insertarnoticia")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("insertarnoticia"))
                        }
                    }else{
                        print("Error al insertar la noticia.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun noticias(codigo: String, grado: String){
//    fun noticias(act: FragmentActivity, codigo: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getNoticias(codigo, grado)
            print(call)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val noticias = call.body()
                print(noticias)
                if (noticias != null) {
                    for (noticia in noticias) {
                        print(noticia?.get("titulo").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun tareas(codigo: String, grado: String){
//    fun noticias(act: FragmentActivity, codigo: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            print("GIULGLI")
            val call = RetroInstance.api.getTareas(codigo, grado)
            print("IHLHLIKBXLHKS")
            print(call)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val tareas = call.body()
                print(tareas)
                if (tareas != null) {
                    for (tarea in tareas) {
                        print(tarea?.get("titulo").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun mensajesChat(codigo: String, grado: String){
//    fun noticias(act: FragmentActivity, codigo: String, grado: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getChat(codigo, grado)
            print(call)
//            act.runOnUiThread { runOnUi
            if (call.isSuccessful) {
                val tareas = call.body()
                print(tareas)
                if (tareas != null) {
                    for (tarea in tareas) {
                        print(tarea?.get("nombre").toString() + "\n")
                    }
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

    fun insertarMensajeChat(idChat: String, idUsuario: String, mensaje:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.insertarMensaje(idChat, idUsuario, mensaje)
//            act.runOnUiThread { runOnUi
//            print(call)
            if (call.isSuccessful) {
                val resultados = call.body()
                if (resultados != null) {
                    print(resultados)
                    val resultado = resultados?.get(0)?.get("insertarMensaje")
                    if (resultado.asInt == 0) {
                        for (resultado in resultados) {
                            print(resultado.get("insertarMensaje"))
                        }
                    }else{
                        print("Error al insertar el mensaje.")
                    }
                }
                else{
                    print("Error al insertar el elemento")
                }
            } else {
                print("Error! Conexion con el API Fallida")
            }
//            } end runOnUi
        }
    }

}

fun main() {
    var x = 0
    while (true) {
        if (x == 0) {
            var firstTodo = Usuario()
            println("Hola Mundo")
            val tester = MainTester()

//            tester.buscarUsuario("1")
//            tester.buscarUsuarios()
//            tester.login("velvet@gmail.com")
//            tester.cursosAdmin()
            tester.cursosEstudiante("soymartha@gmail.com")

//            VACÍO
//            tester.cursosProfesor("shoebill@gmail.com")
//            tester.cursoInfo("soc", "5")
//            tester.buscarProfesores()
           // tester.gradoId("5")
//            tester.infoProfesor("115674562")
//            tester.buscarEstudiantes()
//            tester.infoEstudiante("Hector", "Barrantes")
//            tester.insertarCurso("pru", "prueba", "4", "martes", "08:00:00", "10:00:00")
//            tester.insertarProfesor("12345", "prueba2", "coreo@gmail.com", "contrasenia", "apellidoPrueba")
//            tester.insertarEstudiante("124455", "prueba2", "coreo@gmail.com", "contrasenia", "apellidoPrueba", "4")
            //tester.updateCurso("prueba1","4","prueba2","pruebaUpdate","4","sabado","08:00:00", "10:00:00")
//            tester.updateProfesor("12345", "54321","pruebaUpdate", "coreo@gmail.com", "prueba", "update")

//            tester.updateEstudiante("000","apellidoUpdate", "4684184318", "Hector", "hector@gmail.com", "12345", "Barrantes", "4")


//            tester.asignarProfesor("54321", "prueba", "4")
//            tester.asignarEstudiante("prueba2", "apellidoPrueba", "prueba", "4")

//            tester.buscarEstudiante("4684184318")
//            tester.insertarTarea("mat", "prepa", "prueba", "prueba", "Tarea de prueba", "2021-09-11")
//            tester.insertarNoticia("mat", "prepa", "noticiaPrueba", "probando insertar noticia", "2021-09-14")
//            tester.noticias("mat", "prepa")
//            tester.tareas("mat", "prepa") REVISAR, NO SIRVE :(
//            tester.mensajesChat("mat", "prepa") REVISAR, TAMPOCO SIRVE :(
//            tester.insertarMensajeChat("1","2", "Mensaje de prueba.")  REVISAR ( NO HAY CHAT PARA PROBAR).

            x = 1
        }
    }
}
