package com.gsench.emojis.di.modules

import com.gsench.emojis.api_emojis.EmojisApiImpl
import com.gsench.emojis.data.datasource.RemoteEmojisSource
import com.gsench.emojis.di.components.EmojiAppScope
import dagger.Binds
import dagger.Module

@Module
interface DataSourcesModule {
    @EmojiAppScope
    @Binds
    fun remoteEmojisSource(impl: EmojisApiImpl): RemoteEmojisSource
}