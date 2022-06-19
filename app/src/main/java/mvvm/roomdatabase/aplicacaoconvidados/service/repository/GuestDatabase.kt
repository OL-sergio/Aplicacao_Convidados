package mvvm.roomdatabase.aplicacaoconvidados.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import mvvm.roomdatabase.aplicacaoconvidados.service.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var  INSTANCE : GuestDatabase

        fun getDatabase(context: Context) : GuestDatabase {
            if (!::INSTANCE.isInitialized){
                kotlin.synchronized(GuestDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guestDB")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
        private val MIGRATION_1_2: Migration = object : Migration( 1,2 ){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }


        }
    }
}