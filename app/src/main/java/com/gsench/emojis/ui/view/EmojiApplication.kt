package com.gsench.emojis.ui.view

import android.app.Application
import com.gsench.emojis.di.EmojiAppComponent

class EmojiApplication: Application() {
    val emojiAppComponent = EmojiAppComponent()
}