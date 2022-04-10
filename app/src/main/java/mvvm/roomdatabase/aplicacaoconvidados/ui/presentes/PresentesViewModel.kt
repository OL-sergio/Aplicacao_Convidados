package mvvm.roomdatabase.aplicacaoconvidados.ui.presentes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Presentes Fragment"
    }
    val text: LiveData<String> = _text
}