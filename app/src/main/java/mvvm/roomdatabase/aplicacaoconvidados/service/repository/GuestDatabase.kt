package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room.*
import androidx.room.RoomDatabase
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var  INSTANCE : GuestDatabase

        fun getDatabase(context: Context) : GuestDatabase {
            if (!::INSTANCE.isInitialized){
                kotlin.synchronized(GuestDatabase::class.java){
                    INSTANCE = databaseBuilder(context, GuestDatabase::class.java, "guestDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}