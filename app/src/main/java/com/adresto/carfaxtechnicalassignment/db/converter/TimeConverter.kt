package com.adresto.carfaxtechnicalassignment.db.converter

import androidx.room.TypeConverter
import java.util.*

class TimeConverter {
    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date?): Long? {
        return date?.time
    }
}

