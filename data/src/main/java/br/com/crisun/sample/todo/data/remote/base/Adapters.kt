package br.com.crisun.sample.todo.data.remote.base

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("pt", "BR")
private val datFormat = SimpleDateFormat("yyyy-MM-dd",
    locale
)

object BigDecimalAdapter {
    @FromJson
    fun fromJson(value: String) = BigDecimal(value)

    @ToJson
    fun toJson(value: BigDecimal) = value.toString()
}

object DateAdapter {
    @FromJson
    fun fromJson(value: String) = datFormat.parse(value)

    @ToJson
    fun toJson(value: Date) = datFormat.format(value)
}
