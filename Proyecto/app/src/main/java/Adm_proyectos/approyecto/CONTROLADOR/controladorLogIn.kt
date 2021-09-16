package Adm_proyectos.approyecto.CONTROLADOR

class controladorLogIn {

    fun escogerUsuario(correo: String, contrasenna: String):Int{
        //función de base de datos
        //Código que hice para poder seguir

        if (correo.equals("1")){
            return 1
        }
        else if(correo.equals("2"))
            return 2
        else if(correo.equals("3"))
            return 3
        else
            return 0
    }

}