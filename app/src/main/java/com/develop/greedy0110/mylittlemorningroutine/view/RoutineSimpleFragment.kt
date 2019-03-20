package com.develop.greedy0110.mylittlemorningroutine.view


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import khronos.toString
import kotlinx.android.synthetic.main.fragment_routine_simple.*

/**
 * A simple [Fragment] subclass.
 * 루틴의 간단한 정보를 보여줌
 * 루틴 세부정보로 링크되어서 세부 정보를 확인 할 수 있음
 */
class RoutineSimpleFragment : Fragment() {

    var routine = Routine()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_simple, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        updateLayout(routine)

        // routine 을 클릭하면 상세 루틴 정보 페이지로 이동하자.
        routine_simple_layout.setOnClickListener {
            val intent = Intent(activity, RoutineActivity::class.java)
            intent.putExtra("key", routine.key)
            startActivity(intent)
        }
    }

    private fun updateLayout(routine: Routine) {
        routine_simple_title.text = routine.title
        routine_simple_desc.text = routine.desc
        routine_simple_date.text = routine.startDate.toString("yyyy.MM.dd ~")
        routine_simple_achieve.text = "성취도 : ${routine.achieve} %"
    }
}
