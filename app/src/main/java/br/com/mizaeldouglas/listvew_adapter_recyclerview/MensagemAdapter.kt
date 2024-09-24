package br.com.mizaeldouglas.listvew_adapter_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    private val list: List<Mensagem>,
    private val clique: (String) -> Unit
) : Adapter<MensagemAdapter.MensagemViewHolder>() {


    inner class MensagemViewHolder(
        val itemView: View
    ) : ViewHolder(itemView) {

        val textName: TextView = itemView.findViewById(R.id.txtCardName)
        val textMessage: TextView = itemView.findViewById(R.id.txtCardMensagem)
        val imgViewCard: ImageView = itemView.findViewById(R.id.imgViewCard)
        val cardLayoutViewCard: CardView = itemView.findViewById(R.id.cardLayoutViewCard)

        fun bind(mensagem: Mensagem) {
            textName.text = mensagem.name
            textMessage.text = mensagem.menssage
            val context = imgViewCard.context

//        textTime.text = mensagem.time

            cardLayoutViewCard.setOnClickListener {
                clique(mensagem.name)
            }

//            imgViewCard.setOnClickListener {
//                Toast.makeText(context, "Ola ${mensagem.name}", Toast.LENGTH_LONG).show()
//            }
        }

//        val textName: TextView = itemView.findViewById(R.id.txtName)
//        val textMessage: TextView = itemView.findViewById(R.id.txtMenssage)
//        val textTime: TextView = itemView.findViewById(R.id.txtTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        val itemView = layoutInflater.inflate(
            R.layout.item_cardview,
            parent,
            false
        )


//        val itemView = layoutInflater.inflate(
//            R.layout.item_lista,
//            parent,
//            false
//        )

        return MensagemViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {


        val mensagem = list[position]
        holder.bind(mensagem)


    }

    override fun getItemCount(): Int {
        return list.size
    }


}