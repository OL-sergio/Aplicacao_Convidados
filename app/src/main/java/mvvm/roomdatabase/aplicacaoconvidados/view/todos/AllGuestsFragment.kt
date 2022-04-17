package mvvm.roomdatabase.aplicacaoconvidados.view.todos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentAllGuestsBinding
import mvvm.roomdatabase.aplicacaoconvidados.view.adapter.GuestAdapter


class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val todosViewModel =
            ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Recyclerview
        // 1 - Create one Recyclerview
        val allGuestsRecyclerView = _binding!!.recyclerViewAllGuests
        // 2 - Define one Layout
        allGuestsRecyclerView.layoutManager = LinearLayoutManager(context)
        // 3 - Define one Adapter
        allGuestsRecyclerView.adapter = GuestAdapter()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}