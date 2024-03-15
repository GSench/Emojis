package com.gsench.emojis.ui.view.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsench.emojis.R
import com.gsench.emojis.api_emojis.EmojisApi
import com.gsench.emojis.api_emojis.EmojisApiImpl
import com.gsench.emojis.data.repository.EmojisRepository
import com.gsench.emojis.data.repository.implementation.EmojisRepositoryImpl
import com.gsench.emojis.databinding.ActivityMainBinding
import com.gsench.emojis.ui.model.EmojiViewModel
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.presenter.implementation.AllEmojisPresenterImpl
import com.gsench.emojis.ui.view.AllEmojisView
import com.gsench.emojis.ui.view.list.EmojiListAdapter


class MainActivity : AppCompatActivity(), AllEmojisView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: EmojisRepository
    private lateinit var presenter: AllEmojisPresenter
    private lateinit var emojiListAdapter: EmojiListAdapter
    private lateinit var clipboard: ClipboardManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        dependencyInjection()
        setupView()
    }
    private fun dependencyInjection() {
        repository = EmojisRepositoryImpl(EmojisApiImpl(EmojisApi.instantiateEmojisApi()))
        presenter = AllEmojisPresenterImpl(
            view = this,
            repository = repository
        )
    }
    override fun onStart() {
        super.onStart()
        presenter.start()
    }
    private fun setupView() {
        emojiListAdapter = EmojiListAdapter(::onEmojiClick)
        val emojiLayoutManager = LinearLayoutManager(this)
        with(binding.allEmojisList) {
            layoutManager = emojiLayoutManager
            adapter = emojiListAdapter
        }
    }
    private fun onEmojiClick(emoji: String) {
        clipboard.setPrimaryClip(ClipData.newPlainText("", emoji))
        Toast.makeText(this, getString(R.string.copy_emoji_msg), Toast.LENGTH_SHORT).show()
    }
    override fun showEmojis(emojis: List<EmojiViewModel>) = emojiListAdapter.submitList(emojis)
    override fun showLoading() {
        // TODO("Not yet implemented")
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
    }
    override fun hideLoading() {
        // TODO("Not yet implemented")
    }
    override fun showError() {
        // TODO("Not yet implemented")
        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show()
    }
    override fun showNetworkError() {
        // TODO("Not yet implemented")
        Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show()
    }
}