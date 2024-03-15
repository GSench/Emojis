package com.gsench.emojis.di.components

import com.gsench.emojis.api_emojis.EmojisApi
import com.gsench.emojis.api_emojis.EmojisApiImpl
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.data.repository.implementation.EmojisRepositoryImpl
import dagger.Component

@Component
interface EmojiAppComponent {
    @Component.Factory
    interface Factory {
        fun create(): EmojiAppComponent
    }
    fun allEmojisComponent(): AllEmojisComponent.Factory
}
class EmojiAppComponentManual {
    private val emojisApi: EmojisApi by lazy { EmojisApi.instantiateEmojisApi() }
    private val repository: EmojisRepository by lazy { EmojisRepositoryImpl(EmojisApiImpl(emojisApi)) }
    val allEmojisComponentManual: AllEmojisComponentManual by lazy { AllEmojisComponentManual(repository) }
}