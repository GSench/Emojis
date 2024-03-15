package com.gsench.emojis.ui.view.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsench.emojis.R
import com.gsench.emojis.databinding.ActivityMainBinding
import com.gsench.emojis.di.components.AllEmojisComponent
import com.gsench.emojis.ui.model.EmojiViewModel
import com.gsench.emojis.ui.presenter.AllEmojisPresenter
import com.gsench.emojis.ui.view.AllEmojisView
import com.gsench.emojis.ui.view.EmojiApplication
import com.gsench.emojis.ui.view.list.EmojiListAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity(), AllEmojisView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var component: AllEmojisComponent
    @Inject lateinit var presenter: AllEmojisPresenter
    private lateinit var emojiListAdapter: EmojiListAdapter
    private lateinit var clipboard: ClipboardManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        component = (application as EmojiApplication).emojiAppComponent.allEmojisComponent().create()
        component.inject(this)
        presenter.attachView(this)
        setupView()
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