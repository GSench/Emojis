package com.gsench.emojis.api_emojis.dto

import com.gsench.emojis.data.model.Emoji

data class AllEmojisListItem(
    val category: String?,
    val group: String?,
    val htmlCode: List<String?>?,
    val name: String?,
    val unicode: List<String?>?
)

fun String.fromUTF32() = this
    .substring(2) // remove U+
    .toUInt(radix = 16) // to Unsigned Int 32 bit
    .let { uint -> ByteArray(4){i -> uint.and(0xFFu.shl(i*8)).shr(i*8).toByte()} } // split UInt to bytes
    .reversed() // reversed
    .toByteArray() // reversed(): List<T>
    .let{ String(it, Charsets.UTF_32) } // read as UTF32

fun AllEmojisListItem.toEmoji() = Emoji (
    category = category?:"",
    group = group?:"",
    htmlCode = htmlCode?.joinToString("") ?: "",
    name = name?:"",
    unicode = unicode?.joinToString(""){ it?.fromUTF32() ?: ""} ?: "",
)