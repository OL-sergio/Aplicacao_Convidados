package mvvm.roomdatabase.aplicacaoconvidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mvvm.roomdatabase.aplicacaoconvidados.R
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import mvvm.roomdatabase.aplicacaoconvidados.view.listener.GuestListener
import java.util.prefs.NodeChangeListener

class GuestViewHolder(itemView: View, private var listener: GuestListener)
    : RecyclerView.ViewHolder(itemView) {

    fun bind(guestModel: GuestModel) {

        val textViewGuestName = itemView.findViewById<TextView>(R.id.textView_Guest_Row)
        textViewGuestName.text = guestModel.name

        textViewGuestName.setOnClickListener {
            listener.onClick(guestModel.id)
        }
    }
}