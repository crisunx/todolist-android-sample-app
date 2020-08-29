package br.com.crisun.sample.todo.data.local

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("pt", "BR"))

    @TypeConverter
    fun fromTimestamp(value: String?): Date? {
        return value?.let { format.parse(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): String? {
        return date?.let { format.format(date) }
    }
}

