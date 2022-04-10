package mvvm.roomdatabase.aplicacaoconvidados.view.guest

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import mvvm.roomdatabase.aplicacaoconvidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application){

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest : LiveData<Boolean> = mSaveGuest

    fun saveFormViewModel(name : String, present : Boolean ){
        val guest = GuestModel(name, present)
        mGuestRepository.saveRepository(guest)

    }
}

