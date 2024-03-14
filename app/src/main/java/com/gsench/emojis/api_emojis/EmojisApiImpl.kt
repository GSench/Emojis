package com.gsench.emojis.api_emojis

import com.gsench.emojis.api_emojis.dto.toEmojisList
import com.gsench.emojis.data.datasource.RemoteEmojisSource
import com.gsench.emojis.data.model.Emoji

class EmojisApiImpl: RemoteEmojisSource {
    private val retrofit = EmojisApi.instantiateEmojisApi()
    override suspend fun getAllEmojis(): List<Emoji> = retrofit.getAllEmojisRemote().toEmojisList()

}