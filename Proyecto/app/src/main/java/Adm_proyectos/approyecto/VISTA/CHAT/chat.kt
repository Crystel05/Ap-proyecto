package Adm_proyectos.approyecto.VISTA.CHAT

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.CHAT.constants.sendId
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.chat.*
import kotlinx.coroutines.*


class chat : Fragment() {

    private lateinit var adaptador: adaptadorMensajeria

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.chat, container, false)

        recyclerView()
        clickEvents()

        return view
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

    private fun recyclerView() {
        adaptador = adaptadorMensajeria()
        rv_messages.adapter = adaptador
        rv_messages.layoutManager = LinearLayoutManager(context)

    }

    private fun sendMessage(){
        val message = et_message.text.toString()
        val time = Time.timeStamp()

        if (message.isNotEmpty()){
            et_message.setText("")

            adaptador.insertarMensaje(Message(message, sendId, time))
            rv_messages.scrollToPosition(adaptador.itemCount - 1)
        }
    }

}