package Adm_proyectos.approyecto.VISTA.CHAT

import Adm_proyectos.approyecto.CONTROLADOR.ControladorComponentesVista
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.ADMIN.ADMIN.admin_gc_listaCursos
import Adm_proyectos.approyecto.VISTA.CHAT.Constantes.enviado
import Adm_proyectos.approyecto.VISTA.CHAT.Constantes.recibido
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.chat.*
import kotlinx.coroutines.*

class Chat : AppCompatActivity() {

    private lateinit var adaptador: AdaptadorMensajes
    var messagesList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat)
        recyclerView()

        clickEvents()

        customBotMessage("Hello! Today you're speaking with, how may I help?")
    }

    private fun clickEvents() {

        btn_send.setOnClickListener {
            sendMessage()
        }

        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adaptador.itemCount - 1)

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adaptador.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Tiempo.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, enviado, timeStamp))
            et_message.setText("")

            adaptador.insertarMensaje(Message(message, enviado, timeStamp))
            rv_messages.scrollToPosition(adaptador.itemCount - 1)
        }
    }

    private fun recyclerView() {
        adaptador = AdaptadorMensajes()
        rv_messages.adapter = adaptador
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Tiempo.timeStamp()
                messagesList.add(Message(message, recibido, timeStamp))
                adaptador.insertarMensaje(Message(message, recibido, timeStamp))

                rv_messages.scrollToPosition(adaptador.itemCount - 1)
            }
        }
    }
}