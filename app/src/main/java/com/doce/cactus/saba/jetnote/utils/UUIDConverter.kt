package com.doce.cactus.saba.jetnote.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun stringFromUUID(uuid: UUID): String? {
        return uuid.toString()
    }
    fun uuidFromString(string:String?) : UUID?{
        return UUID.fromString(string)
    }

}