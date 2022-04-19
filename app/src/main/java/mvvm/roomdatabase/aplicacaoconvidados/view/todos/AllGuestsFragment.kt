package mvvm.roomdatabase.aplicacaoconvidados.view.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mvvm.roomdatabase.aplicacaoconvidados.R
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentAllGuestsBinding
import mvvm.roomdatabase.aplicacaoconvidados.view.adapter.GuestAdapter


class AllGuestsFragment: Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null

    private var mAllGuestsViewModel: AllGuestsViewModel? = null
    private val mAdapter: GuestAdapter = GuestAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       mAllGuestsViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Recyclerview
        // 1 - Create one Recyclerview
        val allGuestsRecyclerView = root.findViewById<RecyclerView>(R.id.recyclerView_all_guests)
        // 2 - Define one Layout
        allGuestsRecyclerView.layoutManager = LinearLayoutManager(context)
        // 3 - Define one Adapter
        allGuestsRecyclerView.adapter = mAdapter

        observer()

       mAllGuestsViewModel!!.loadRepository()

        return root
    }

    private fun observer() {
        mAllGuestsViewModel?.guestList?.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}