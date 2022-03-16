package com.adresto.carfaxtechnicalassignment.db.converter

import androidx.room.TypeConverter
import com.adresto.carfaxtechnicalassignment.model.History
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class HistoryConverter {
    val gson = Gson()

    @TypeConverter
    fun arrayFromString(value: String?): List<History>? {
        val listType: Type = object : TypeToken<List<History?>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun arrayToString(values: List<History>?): String? {
        return gson.toJson(values)
    }
}