package com.develop.greedy0110.mylittlemorningroutine.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import khronos.minutes
import khronos.toString

class RoutineRecordAdapter: RecyclerView.Adapter<RoutineRecordAdapter.ViewHolder>() {
    var data = mutableListOf<Routine.RoutineRecord>()

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val date = view.findViewById<TextView>(R.id.record_content_date)
        val achieve = view.findViewById<TextView>(R.id.record_content_achieve)
        // TODO todo_list 와 check_list 를 활용해서 데이터를 추가적으로 보여주어야 한다!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.record_content, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = data.size

    // 해당 pos에 그려질 때 호출!
    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        if (data.size <= pos) return
        holder.date.text = data[pos].date.toString("yyyy.MM.dd ~")
        holder.achieve.text = "달성도 : ${data[pos].achieve} %"
    }
}