package mvvm.roomdatabase.aplicacaoconvidados.view.todos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllGuestsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is todos Fragment"
    }
    val text: LiveData<String> = _text
}