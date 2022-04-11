package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import android.text.Selection
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

    fun deleteRepository(id : Int) :Boolean{
        return try {

            val db = mGuestDatabaseHelper.writableDatabase
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection , args)

            true
        }catch (e: Exception){
            false
        }
    }

    @SuppressLint("Range")
    fun getOneGuest(id : Int) : GuestModel? {

        var guest : GuestModel? = null

        return try {
            val db = mGuestDatabaseHelper.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ? "
            val args = arrayOf(guest!!.id.toString())

            val cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                selection,
                args,
                null, null, null
            )

            if (cursor != null && cursor.count > 0 ){
                cursor.moveToFirst()

               val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
               val present = (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                guest = GuestModel(id, name, present)
            }
            cursor!!.close()

           guest
        }catch (e: Exception){
            guest
        }
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