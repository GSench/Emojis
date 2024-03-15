package com.gsench.emojis.di.components

import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.presenter.implementation.AllEmojisPresenterImpl
import com.gsench.emojis.ui.view.activity.MainActivity
import dagger.Subcomponent

@Subcomponent
//@ComponentAllEmojisScope
interface AllEmojisComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AllEmojisComponent
    }
}

class AllEmojisComponentManual(private val repository: EmojisRepository) {
    private val presenter: AllEmojisPresenter by lazy { AllEmojisPresenterImpl(repository) }
    fun inject(activity: MainActivity){
        activity.presenter = presenter
    }
}