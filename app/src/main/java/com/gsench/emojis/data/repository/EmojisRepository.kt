package com.gsench.emojis.data.repository

import com.gsench.emojis.data.model.Emoji
import com.gsench.emojis.data.model.LoadResult

interface EmojisRepository {
    suspend fun getAllEmojis(): LoadResult<List<Emoji>>
}