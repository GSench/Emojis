package com.gsench.emojis.di.components

import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.view.activity.MainActivity
import dagger.Subcomponent
import javax.inject.Scope

@Scope annotation class AllEmojisScope

@Subcomponent
@AllEmojisScope
interface AllEmojisComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AllEmojisComponent
    }
    fun presenter(): AllEmojisPresenter
    fun inject(activity: MainActivity)
}
