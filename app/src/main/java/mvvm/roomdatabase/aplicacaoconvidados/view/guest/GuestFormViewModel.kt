package mvvm.roomdatabase.aplicacaoconvidados.view.guest


import android.annotation.SuppressLint
import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import mvvm.roomdatabase.aplicacaoconvidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application){


    @SuppressLint("StaticFieldLeak")
    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest : LiveData<Boolean> = mSaveGuest

    fun saveFormViewModel(name : String, present : Boolean ){
        val guest = GuestModel( name = name, present = present)
        mSaveGuest.value = mGuestRepository.saveRepository(guest)
    }
}

