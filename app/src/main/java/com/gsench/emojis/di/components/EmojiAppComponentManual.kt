package com.gsench.emojis.di.components

import com.gsench.emojis.api_emojis.EmojiApiModule
import com.gsench.emojis.di.modules.DataSourcesModule
import com.gsench.emojis.di.modules.PresenterModule
import com.gsench.emojis.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Scope

@Scope annotation class EmojiAppScope

@EmojiAppScope
@Component(modules = [
    PresenterModule::class,
    RepositoryModule::class,
    DataSourcesModule::class,
    EmojiApiModule::class
])
interface EmojiAppComponent {
    @Component.Factory
    interface Factory {
        fun create(): EmojiAppComponent
    }
    fun allEmojisComponent(): AllEmojisComponent.Factory
}