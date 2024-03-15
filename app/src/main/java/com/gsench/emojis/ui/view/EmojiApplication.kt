package com.gsench.emojis.ui.view

import android.app.Application
import com.gsench.emojis.api_emojis.EmojisApi
import com.gsench.emojis.api_emojis.EmojisApiImpl
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.data.repository.implementation.EmojisRepositoryImpl
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.presenter.implementation.AllEmojisPresenterImpl

class EmojiApplication: Application() {

    lateinit var emojisApi: EmojisApi
    lateinit var repository: EmojisRepository
    lateinit var allEmojisPresenter: AllEmojisPresenter
        private set
    override fun onCreate() {
        super.onCreate()
        emojisApi = EmojisApi.instantiateEmojisApi()
        repository = EmojisRepositoryImpl(EmojisApiImpl(emojisApi))
        allEmojisPresenter = AllEmojisPresenterImpl(
            repository = repository
        )
    }

}