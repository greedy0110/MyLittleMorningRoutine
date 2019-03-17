package com.develop.greedy0110.mylittlemorningroutine.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

class RoutineRecordFragment : Fragment() {

    var routine: Routine = Routine()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_record, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        updateLayout(routine)
    }

    // routine 의 내용으로 화면을 구성해줌
    // 해당 함수는 view들의 값을 변경하기 때문에 onActivityCreated 이후에 호출되어야함.
    fun updateLayout(routine: Routine) {
        // TODO routine.records 를 이용해서 record_list (recycler view) 를 구성해 준다.
    }
}
