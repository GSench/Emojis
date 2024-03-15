package com.gsench.emojis.ui.view

import android.app.Application
import com.gsench.emojis.di.components.DaggerEmojiAppComponent
import com.gsench.emojis.di.components.EmojiAppComponent

class EmojiApplication: Application() {
    lateinit var emojiAppComponent: EmojiAppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        emojiAppComponent = DaggerEmojiAppComponent.create()
    }
}