package Adm_proyectos.approyecto.CONTROLADOR

import API.RetroInstance
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class controladorLogIn {

    fun escogerUsuario(
        activity: AppCompatActivity,
        correo: String,
        contrasenna: String,
        tipo_usuario: TextView
    ) {

        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroInstance.api.getLogin(correo)
            val usuario = call.body()?.get(0)
            val idUsuario = usuario?.get("ID").toString()
            val callTipoUsuario = RetroInstance.api.getTipoUsuario(idUsuario)
            val tipoUsuario = callTipoUsuario.body()?.get(0)?.get("tipousuid").toString()

            activity.runOnUiThread {
                var datos = ""
                if (call.isSuccessful) {

                    datos = usuario?.get("nombre").toString() + "_" + tipoUsuario

                    // Obtiene el primer elemento de la lista (json) y la contrasenna del Json
                    val miContrasenna = call.body()?.get(0)?.get("contrasenna")
                    if (contrasenna.equals(miContrasenna)) {
                        tipo_usuario.text = datos
                    } else {
                        tipo_usuario.text = "x"
                    }
                } else {
                    tipo_usuario.text = "x"
                }
            }
        }
    }


}