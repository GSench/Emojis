package com.gsench.emojis.ui.model

import com.gsench.emojis.data.model.Emoji

data class EmojiViewModel (
    val name: String,
    val unicode: String,
    val category: String,
    val group: String,
)

fun Emoji.toViewModel() = EmojiViewModel (
    name = name,
    unicode = unicode,
    category = category,
    group = group,
)