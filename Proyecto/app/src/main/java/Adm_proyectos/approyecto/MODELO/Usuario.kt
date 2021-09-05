package Adm_proyectos.approyecto.MODELO

open class Usuario (nombre:String = "", apellidos:String = "", correo:String = "", cedula:String = "", contrasenna:String = "") {

    var nombre: String
    var apellidos: String
    var correo: String
    var cedula: String
    var contrasenna: String

    init {
        this.nombre = nombre
        this.apellidos = apellidos
        this.correo = correo
        this.cedula = cedula
        this.contrasenna = contrasenna
    }


}