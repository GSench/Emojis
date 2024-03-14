package com.gsench.emojis.api_emojis.dto

import com.gsench.emojis.data.model.Emoji

class AllEmojisList : ArrayList<AllEmojisListItem>()
fun AllEmojisList.toEmojisList(): List<Emoji> = map {it.toEmoji()}