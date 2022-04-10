package mvvm.roomdatabase.aplicacaoconvidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import mvvm.roomdatabase.aplicacaoconvidados.service.repository.GuestRepository

class GuestFormViewModel : ViewModel(){

    private val mGuestRepository: GuestRepository = GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest : LiveData<Boolean> = mSaveGuest

    fun saveFormViewModel(name : String, present : Boolean ){
        val guest = GuestModel(name, present)
        mGuestRepository.saveRepository(guest)

    }
}

