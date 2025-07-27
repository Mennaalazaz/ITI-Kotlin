package com.example.roomdatabase.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.Local_db.ToDoEntity
import com.example.roomdatabase.R

class ToDoAdapter(private val onDelete: (ToDoEntity) -> Unit) : RecyclerView.Adapter<ToDoAdapter.TaskViewHolder>() {
    private var taskList = emptyList<ToDoEntity>()
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.task_title)
        val desc = itemView.findViewById<TextView>(R.id.task_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.title.text = task.title
        holder.desc.text = task.description
        holder.itemView.setOnLongClickListener {
            onDelete(task)
            true
        }
    }

    fun setData(tasks: List<ToDoEntity>) {
        this.taskList = tasks
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}


