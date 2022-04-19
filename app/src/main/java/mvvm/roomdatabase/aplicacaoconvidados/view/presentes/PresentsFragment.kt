package mvvm.roomdatabase.aplicacaoconvidados.view.presentes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentPresentsBinding


class PresentsFragment : Fragment() {

    private var _binding: FragmentPresentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val presentsFragment = ViewModelProvider(this).get(PresentsViewModel::class.java)
        _binding = FragmentPresentsBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}