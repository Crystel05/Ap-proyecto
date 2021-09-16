package Adm_proyectos.approyecto.CONTROLADOR

import API.RetroInstance
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ControladorBaseDatos : AppCompatActivity() {
    val loginController = controladorLogIn();
    var tipoUsuario = 0;


    fun login(correo: String, contrasenna: String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getLogin(correo)

            runOnUiThread {
                if (call.isSuccessful) {

    //              Obtiene el primer elemento de la lista (json) y la contrasenna del Json
                    val miContrasenna = call.body()?.get(0)?.get("contrasenna")
                    if (contrasenna.equals(miContrasenna)) {
                        tipoUsuario = 1
                    }
                } else {
                    print("Error! Conexion con el API Fallida")
                }
            }
        }
    }



}


fun main(){
    val cont = ControladorBaseDatos()
    cont.login("jabonzote@gmail.com", "queso")
    print(cont.tipoUsuario)
}







