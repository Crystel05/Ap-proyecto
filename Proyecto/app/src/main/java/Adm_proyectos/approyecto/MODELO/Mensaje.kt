package Adm_proyectos.approyecto.MODELO

import java.time.LocalTime

class Mensaje(mensaje: String, remitente: Usuario, horaEnviado: LocalTime) {
    var mensaje : String
    var remitente : Usuario
    var horaEnviado : LocalTime

    init {
        this.mensaje = mensaje
        this.remitente = remitente
        this.horaEnviado = horaEnviado
    }
}