package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import android.content.Context
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel


class GuestRepository(context: Context){

    //Access in to database
    private val mDatabase = GuestDatabase.getDatabase(context).guestDAO()

    //CRUD - Create, Read, Update, Delete
    fun saveRepository(guest : GuestModel): Boolean {
        return mDatabase.saveDatabase(guest) > 0
    }

    fun updateRepository(guest : GuestModel): Boolean{
        return mDatabase.updateDatabase(guest) > 0
    }

    fun deleteRepository(guest: GuestModel) {
        mDatabase.deleteDatabase(guest)
    }
    /*
    *
    * */
    fun getOneGuestRepository(id : Int) : GuestModel {
        return mDatabase.getOneGuest(id)
    }


    fun getAllInvitedGuestRepository() : List<GuestModel> {
        return mDatabase.getAllInvited()
    }


    fun getPresentGuestsRepository() : List<GuestModel> {
        return mDatabase.getAllPresents()
    }


    fun getAbsentGuestsRepository() : List<GuestModel> {
        return mDatabase.getAllAbsents()
    }

}