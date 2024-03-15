package com.gsench.emojis.di

import com.gsench.emojis.api_emojis.EmojisApi
import com.gsench.emojis.api_emojis.EmojisApiImpl
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.data.repository.implementation.EmojisRepositoryImpl

class EmojiAppComponent {
    private val emojisApi: EmojisApi by lazy { EmojisApi.instantiateEmojisApi() }
    private val repository: EmojisRepository by lazy { EmojisRepositoryImpl(EmojisApiImpl(emojisApi)) }
    val allEmojisComponent: AllEmojisComponent by lazy { AllEmojisComponent(repository) }
}