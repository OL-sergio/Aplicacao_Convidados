package mvvm.roomdatabase.aplicacaoconvidados.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mvvm.roomdatabase.aplicacaoconvidados.R
import mvvm.roomdatabase.aplicacaoconvidados.databinding.ActivityMainBinding
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentAllGuestsBinding
import mvvm.roomdatabase.aplicacaoconvidados.databinding.RowGuestsBinding
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import mvvm.roomdatabase.aplicacaoconvidados.view.listener.GuestListener
import java.util.prefs.NodeChangeListener

class GuestViewHolder(
    private val itemBinding: RowGuestsBinding, private var listener: GuestListener
    ): RecyclerView.ViewHolder(itemBinding.root) {


    fun bind(guestModel: GuestModel) {

        itemBinding.textViewGuestRow.text = guestModel.name

        itemBinding.textViewGuestRow.setOnClickListener {
            listener.onClick(guestModel.id)
        }

        itemBinding.textViewGuestRow.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover){ dialog, which ->
                    listener.onDelete(guestModel.id)

                }
                .setNegativeButton(R.string.cancelar,null)
                .show()

            true
        }
    }
}