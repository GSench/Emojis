package com.gsench.emojis.api_emojis

import com.gsench.emojis.api_emojis.dto.toEmojisList
import com.gsench.emojis.data.datasource.RemoteEmojisSource
import com.gsench.emojis.data.model.Emoji

class EmojisApiImpl(private val retrofit: EmojisApi): RemoteEmojisSource {
    override suspend fun getAllEmojis(): List<Emoji> = retrofit.getAllEmojisRemote().toEmojisList()
}