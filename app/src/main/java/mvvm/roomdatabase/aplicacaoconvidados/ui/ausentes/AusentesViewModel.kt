package mvvm.roomdatabase.aplicacaoconvidados.ui.ausentes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AusentesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ausentes Fragment"
    }
    val text: LiveData<String> = _text
}