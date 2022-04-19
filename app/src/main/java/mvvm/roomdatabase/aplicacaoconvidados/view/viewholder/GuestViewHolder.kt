package mvvm.roomdatabase.aplicacaoconvidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mvvm.roomdatabase.aplicacaoconvidados.R
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel

class GuestViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    fun bind(guestModel: GuestModel) {

        val textViewGuestName = itemView.findViewById<TextView>(R.id.textView_Guest_Row)
        textViewGuestName.text = guestModel.name
    }
}