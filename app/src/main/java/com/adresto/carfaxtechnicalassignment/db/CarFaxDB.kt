package com.adresto.carfaxtechnicalassignment.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adresto.carfaxtechnicalassignment.db.converter.HistoryConverter
import com.adresto.carfaxtechnicalassignment.db.converter.StringArrayConverter
import com.adresto.carfaxtechnicalassignment.db.dao.ListingDao
import com.adresto.carfaxtechnicalassignment.model.*

@Database(
    entities = [
        Listing::class
    ],
    version = 1
)
@TypeConverters(StringArrayConverter::class, HistoryConverter::class)
abstract class CarFaxDB : RoomDatabase() {
    abstract fun listingDao(): ListingDao

    companion object {
        fun getDb(application: Application): CarFaxDB =
            Room.databaseBuilder<CarFaxDB>(application, CarFaxDB::class.java, "carfax_db").build()
    }
}