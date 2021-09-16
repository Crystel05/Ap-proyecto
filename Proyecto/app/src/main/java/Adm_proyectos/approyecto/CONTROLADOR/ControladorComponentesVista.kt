package Adm_proyectos.approyecto.CONTROLADOR


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class ControladorComponentesVista {
    val controlador = ControladorBaseDatos()
    val controladorLogin = controladorLogIn()

    fun cambiarFragment(fragment: Fragment, id:Int, activity: FragmentActivity){
        val transacion = (activity).supportFragmentManager.beginTransaction()
        transacion.replace(id, fragment)
        transacion.commit()
    }

//    fun escogerUsuario(activity: FragmentActivity, correo: String, contrasenna: String):Int{
//        //función de base de datos
//        //Código que hice para poder seguir
////        controlador.login(activity, correo, contrasenna)
//        val resultado = controladorLogin.tipoUsurio
//        if (resultado == 1){
//            return 1
//        }
//        else if(correo.equals("2"))
//            return 2
//        else if(correo.equals("3"))
//            return 3
//        else
//            return 0
//    }
}