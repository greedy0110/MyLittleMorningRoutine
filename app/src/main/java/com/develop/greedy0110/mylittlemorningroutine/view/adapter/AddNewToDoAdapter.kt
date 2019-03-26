package com.develop.greedy0110.mylittlemorningroutine.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.ToDo

class AddNewToDoAdapter : RecyclerView.Adapter<AddNewToDoAdapter.ViewHolder>() {
    var data = mutableListOf<ToDo>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.newtodo_title)
        val desc = view.findViewById<TextView>(R.id.newtodo_desc)
        val xButton = view.findViewById<Button>(R.id.todo_delete)
        val upButton = view.findViewById<Button>(R.id.todo_up)
        val downButton = view.findViewById<Button>(R.id.todo_down)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newtodo_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    // 실제로 그려저야 할 때 호출된다.
    // data 변경후에는 다시금 그려주도록 만들어야한다.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            title.text = data[position].title
            desc.text = data[position].desc

            upButton.isEnabled = true; downButton.isEnabled = true
            if (position == 0) {
                upButton.isEnabled = false
            }
            if (position == data.size - 1) {
                downButton.isEnabled = false
            }
            // 이전 아이템 위치로 이동
            upButton.setOnClickListener {
                swapData(position, position - 1)
                notifyItemRangeChanged(position-1, 2)
            }
            // 다음 아이템 위치로 이동
            downButton.setOnClickListener {
                swapData(position, position + 1)
                notifyItemRangeChanged(position, 2)
            }

            // 자신을 삭제하고 앞에 있는 데이터들을 전부 포지션 변경해야한다.
            xButton.setOnClickListener {
                data.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }

    fun addData(toDo: ToDo) {
        data.add(toDo)
        notifyDataSetChanged()
    }

    private fun swapData(pos1: Int, pos2: Int) {
        val temp = data[pos1]
        data[pos1] = data[pos2]
        data[pos2] = temp
    }
}