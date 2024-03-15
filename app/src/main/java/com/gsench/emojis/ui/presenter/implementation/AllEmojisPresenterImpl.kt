package com.gsench.emojis.ui.presenter.implementation

import com.gsench.emojis.data.model.LoadResult
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.ui.model.EmojiViewModel
import com.gsench.emojis.ui.model.toViewModel
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.view.AllEmojisView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllEmojisPresenterImpl(private val repository: EmojisRepository): AllEmojisPresenter {
    private lateinit var view: AllEmojisView
    private var emojis: List<EmojiViewModel> = listOf()
    override fun start() {
        if(emojis.isEmpty()) loadAllEmojisList()
        else view.showEmojis(emojis)
    }

    override fun attachView(view: AllEmojisView) {
        this.view = view
    }

    private fun loadAllEmojisList(){
        view.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            when(val loadResult = repository.getAllEmojis()){
                is LoadResult.Error -> launchOnUIThread { view.showError() }
                is LoadResult.NetworkError -> launchOnUIThread { view.showNetworkError() }
                is LoadResult.Success -> {
                    emojis = loadResult.data.map { it.toViewModel() }
                    launchOnUIThread {
                        view.hideLoading()
                        view.showEmojis(emojis)
                    }
                }
            }
        }
    }
    private fun launchOnUIThread(block: suspend CoroutineScope.() -> Unit) = CoroutineScope(Dispatchers.Main).launch(block = block)
}
