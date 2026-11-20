package com.imthiyas.to_dolist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.imthiyas.to_dolist.data.Todo
import com.imthiyas.to_dolist.databinding.TodoItemBinding

class TodoAdapter(private val onItemClicked: (Todo) -> Unit) :
    ListAdapter<Todo, TodoAdapter.TodoViewHolder>(DiffCallback) {

    class TodoViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Todo?, onItemClicked: (Todo) -> Unit) {
            binding.todoTitle.text = item?.title
            binding.checkBox.isChecked = item?.isCompleted == true

            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                item?.copy(isCompleted = isChecked)?.let { onItemClicked(it) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClicked)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Todo, newItem: Todo) = oldItem == newItem
        }
    }

}