package com.example.segopecel2.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.segopecel2.dao.Peceldao
import com.example.segopecel2.model.Pecel

@Database(entities = [Pecel::class], version = 2, exportSchema = false )
abstract class PecelDatabase:RoomDatabase() {
    abstract fun Peceldao(): Peceldao
    companion object{
        private var INSTANCE: PecelDatabase? = null

        private val migration1To2: Migration = object: Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE pecel_pecel ADD COLUMN latitude Double DEFAULT 0.0")
                database.execSQL("ALTER TABLE pecel_pecel ADD COLUMN longtude Double DEFAULT 0.0")
            }

        }

        fun getDatabase(context: Context):PecelDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PecelDatabase::class.java,
                "pecel_database_1"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}