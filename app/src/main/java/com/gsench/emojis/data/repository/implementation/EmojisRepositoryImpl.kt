package com.gsench.emojis.data.repository.implementation

import com.gsench.emojis.data.datasource.RemoteEmojisSource
import com.gsench.emojis.data.model.Emoji
import com.gsench.emojis.data.model.LoadResult
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.di.components.EmojiAppScope
import java.net.ConnectException
import javax.inject.Inject

@EmojiAppScope
class EmojisRepositoryImpl @Inject constructor (
    private val remoteEmojisSource: RemoteEmojisSource
) : EmojisRepository {
    override suspend fun getAllEmojis() : LoadResult<List<Emoji>> =
        try {
            val response = remoteEmojisSource.getAllEmojis()
            LoadResult.Success(response)
        } catch (e: Throwable) {
            if (e is ConnectException) {
                LoadResult.NetworkError(e)
            } else {
                LoadResult.Error(e)
            }
        }
}