package com.gmail.vladkhinski.database_hw.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.gmail.vladkhinski.database_hw.databinding.ItemUserBinding
import com.gmail.vladkhinski.database_hw.model.User

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(user: User) {
        binding.textView.text = "${user.id}) ${user.name} ${user.surname}"
    }
}