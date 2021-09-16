package Adm_proyectos.approyecto.VISTA.CHAT

import Adm_proyectos.approyecto.R
import Adm_proyectos.approyecto.VISTA.CHAT.Constantes.enviado
import Adm_proyectos.approyecto.VISTA.CHAT.Constantes.recibido
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.mensajes.view.*

class AdaptadorMensajes: RecyclerView.Adapter<AdaptadorMensajes.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {

                messagesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mensajes, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        when (currentMessage.id) {
            enviado -> {

                holder.itemView.tv_message.apply {
                    text = currentMessage.mensaje
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }
            recibido -> {
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.mensaje
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    fun insertarMensaje(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }

}