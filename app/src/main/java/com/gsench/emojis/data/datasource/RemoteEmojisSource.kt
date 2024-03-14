package com.gsench.emojis.data.datasource

import com.gsench.emojis.data.model.Emoji

interface RemoteEmojisSource {
    suspend fun getAllEmojis(): List<Emoji>
}