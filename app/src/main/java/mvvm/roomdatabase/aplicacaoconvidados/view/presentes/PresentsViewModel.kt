package mvvm.roomdatabase.aplicacaoconvidados.view.presentes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is presentes Fragment"
    }
    val text: LiveData<String> = _text
}