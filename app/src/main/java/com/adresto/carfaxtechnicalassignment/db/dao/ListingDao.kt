package com.adresto.carfaxtechnicalassignment.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.adresto.carfaxtechnicalassignment.model.Listing
import io.reactivex.Flowable

@Dao
interface ListingDao {
    @Query("SELECT * FROM listing")
    fun getAllListings(): Flowable<List<Listing>>

    @Insert(onConflict = REPLACE)
    fun insertListings(listings: List<Listing>): List<Long>
}