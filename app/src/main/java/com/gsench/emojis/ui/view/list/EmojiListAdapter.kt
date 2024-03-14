package com.gsench.emojis.ui.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsench.emojis.databinding.EmojiListItemBinding
import com.gsench.emojis.ui.model.EmojiViewModel

class EmojiListAdapter(
    private val onEmojiClick: (emoji: String) -> Unit
) : ListAdapter<EmojiViewModel, EmojiListAdapter.EmojiListItemViewHolder>(EmojiListDiffUtil()) {

    class EmojiListItemViewHolder (private val binding: EmojiListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(emoji: EmojiViewModel, onEmojiClick: (emoji: String) -> Unit) = with(binding) {
            emojiIcon.text = emoji.unicode
            emojiName.text = emoji.name
            emojiCategory.text = emoji.category
            emojiGroup.text = emoji.group
            root.setOnClickListener { onEmojiClick(emoji.unicode) }
        }
    }
    class EmojiListDiffUtil : DiffUtil.ItemCallback<EmojiViewModel>() {
        override fun areItemsTheSame(oldItem: EmojiViewModel, newItem: EmojiViewModel) = oldItem.unicode == newItem.unicode
        override fun areContentsTheSame(oldItem: EmojiViewModel, newItem: EmojiViewModel) = oldItem.unicode == newItem.unicode
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EmojiListItemBinding.inflate(inflater, parent, false)
        return EmojiListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmojiListItemViewHolder, position: Int) =
        holder.bind(currentList[position], onEmojiClick)

    override fun submitList(list: List<EmojiViewModel>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

}