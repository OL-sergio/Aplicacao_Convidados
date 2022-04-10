package mvvm.roomdatabase.aplicacaoconvidados.ui.presentes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentAusentesBinding
import mvvm.roomdatabase.aplicacaoconvidados.databinding.FragmentPresentesBinding

class PresentesFragment : Fragment() {

    private var _binding: FragmentPresentesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val presentesViewModel =
            ViewModelProvider(this).get(PresentesViewModel::class.java)

        _binding = FragmentPresentesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPresentes
        presentesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}