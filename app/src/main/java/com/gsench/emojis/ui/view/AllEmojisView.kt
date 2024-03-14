package com.gsench.emojis.ui.view

import com.gsench.emojis.ui.model.EmojiViewModel

interface AllEmojisView {
    fun showEmojis(emojis: List<EmojiViewModel>)
    fun showLoading()
    fun hideLoading()
    fun showError()
    fun showNetworkError()
}