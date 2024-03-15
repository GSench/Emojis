package com.gsench.emojis.ui.presenter

import com.gsench.emojis.ui.view.AllEmojisView

interface AllEmojisPresenter {
    fun start()
    fun attachView(view: AllEmojisView)
}