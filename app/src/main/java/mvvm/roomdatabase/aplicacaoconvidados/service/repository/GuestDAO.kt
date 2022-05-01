package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import androidx.room.*
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel

@Dao
interface  GuestDAO {

    @Insert
    fun saveDatabase(guestModel: GuestModel) : Long

    @Update
    fun updateDatabase(guestModel: GuestModel) : Int

    @Delete
    fun deleteDatabase(guestModel: GuestModel)

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun getOneGuest(id: Int): GuestModel

    @Query("SELECT * FROM Guest")
    fun getAllInvited(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAllAbsents():  List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getAllPresents(): List<GuestModel>





}