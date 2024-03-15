package com.gsench.emojis.di.modules

import com.gsench.emojis.di.components.EmojiAppScope
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.presenter.implementation.AllEmojisPresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface PresenterModule {
    @EmojiAppScope
    @Binds
    fun allEmojisPresenter(impl: AllEmojisPresenterImpl): AllEmojisPresenter
}