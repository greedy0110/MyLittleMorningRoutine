package com.develop.greedy0110.mylittlemorningroutine.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.ToDo

class ToDoAdapter : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {
    var data = mutableListOf<ToDo>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.todo_content_title)
        val desc = view.findViewById<TextView>(R.id.todo_content_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size


    // pos 위치에 있는 데이터를 <보여줘야> 할 때 호출
    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        if (data.size <= pos) return
        holder.title.text = data[pos].title
        holder.desc.text = data[pos].desc
    }
}