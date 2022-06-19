package mvvm.roomdatabase.aplicacaoconvidados.view.viewmodel


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
    private val mGuestRepository: GuestRepository = GuestRepository(mContext)

    private var mSaveGuest = MutableLiveData<String>()
    val saveGuest : LiveData<String> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest : LiveData<GuestModel> = mGuest

    fun saveFormViewModel(id : Int, name : String, present : Boolean ){
        val guest = GuestModel().apply {
            this.id = id
            this.name = name
            this.present = present
        }

        if (guest.id == 0 ){
            if (mGuestRepository.saveRepository(guest)){
                mSaveGuest.value = "Inserido com Sucesso"
            } else {
                mSaveGuest.value = "Falha"
            }

        }else {
            if (mGuestRepository.updateRepository(guest)){
                mSaveGuest.value = "Atulizaso com sucesso"
            } else {
                mSaveGuest.value = "Falha"
            }

        }
    }

    fun load(id :Int){
        mGuest.value = mGuestRepository.getOneGuestRepository(id)
    }
}

