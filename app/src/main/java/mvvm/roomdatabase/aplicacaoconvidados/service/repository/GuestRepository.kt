package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel

class GuestRepository {

    fun getAllRepository() : List<GuestModel> {
        val list : MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresentRepository() : List<GuestModel> {
        val list : MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAwayRepository() : List<GuestModel> {
        val list : MutableList<GuestModel> = ArrayList()
        return list
    }


    //CRUD - Create, Read, Update, Delete
    fun saveRepository(guest : GuestModel){


    }

    fun updateRepository(guest : GuestModel){


    }

    fun deleteRepository(guest : GuestModel){


    }
}