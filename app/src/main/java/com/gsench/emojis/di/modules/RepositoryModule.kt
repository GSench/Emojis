package com.gsench.emojis.di.modules

import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.data.repository.implementation.EmojisRepositoryImpl
import com.gsench.emojis.di.components.EmojiAppScope
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @EmojiAppScope
    @Binds
    fun allEmojisPresenter(impl: EmojisRepositoryImpl): EmojisRepository
}