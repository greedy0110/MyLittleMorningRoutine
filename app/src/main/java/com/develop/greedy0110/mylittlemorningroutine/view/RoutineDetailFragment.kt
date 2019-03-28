package com.develop.greedy0110.mylittlemorningroutine.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineMemoryModel
import com.develop.greedy0110.mylittlemorningroutine.presenter.RoutineDisplayPresenter
import com.develop.greedy0110.mylittlemorningroutine.view.adapter.ToDoAdapter
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineView
import khronos.toString
import kotlinx.android.synthetic.main.fragment_routine_detail.*

// 데이터를 단순히 보여주기만 할 화면
class RoutineDetailFragment : Fragment(), RoutineView {

    var key: String = "demo"
    private lateinit var presenter: RoutineDisplayPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = RoutineDisplayPresenter(RoutineMemoryModel(), key)
        presenter.bind(this)
        presenter.onActivityCreated()
    }

    // routine 의 내용으로 화면을 구성해줌
    // 해당 함수는 view들의 값을 변경하기 때문에 onActivityCreated 이후에 호출되어야함.
    override fun updateLayout(routine: Routine) {
        weekday_weekend.text = if (routine.isWeekDay) "주간 루틴" else "주말 루틴"
        title.text = routine.title
        description.text = routine.desc
        start_date.text = routine.startDate.toString("yyyy.MM.dd ~")
        achieve.text = "성취도 : ${routine.achieve.toInt()} %"

        // routine.toDoList 를 이용해서 todo_list (recycler view) 를 구성해 준다.
        val adapter = ToDoAdapter()
        adapter.data = routine.toDoList
        todo_list.layoutManager = LinearLayoutManager(activity)
        todo_list.adapter = adapter
    }
}