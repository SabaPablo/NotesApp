package com.doce.cactus.saba.jetnote.utils

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {


    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long): Date? {
        return Date(timestamp)
    }

}