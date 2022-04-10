package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import android.content.ContentValues
import android.content.Context
import mvvm.roomdatabase.aplicacaoconvidados.service.constants.DataBaseConstants
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context){


    //Singleton
    private var mGuestDatabaseHelper: GuestDatabaseHelper = GuestDatabaseHelper(context)

    companion object{
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository{
            if (!::repository.isInitialized){
                repository = GuestRepository(context)
            }
            return GuestRepository(context)
        }

    }

    //CRUD - Create, Read, Update, Delete
    fun saveRepository(guest : GuestModel): Boolean {
        return try {
            val db = mGuestDatabaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.present)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        }catch (e: Exception){
            false
        }
    }

    fun updateRepository(guest : GuestModel): Boolean{
        return try {
            val db = mGuestDatabaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.present)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ? "
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues,selection, args )

            true
        }catch (e: Exception){
            false
        }

    }

    fun deleteRepository(guest : GuestModel){


    }

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



}