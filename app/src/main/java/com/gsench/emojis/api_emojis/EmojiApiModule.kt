package com.gsench.emojis.api_emojis

import dagger.Module
import dagger.Provides

@Module
interface EmojiApiModule {
    companion object {
        @Provides
        fun emojisApi(): EmojisApi = EmojisApi.instantiateEmojisApi()
    }

}