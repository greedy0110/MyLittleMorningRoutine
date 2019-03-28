package com.develop.greedy0110.mylittlemorningroutine.view


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.utils.showDialog
import com.develop.greedy0110.mylittlemorningroutine.view.dialog.AddRoutineDialog
import kotlinx.android.synthetic.main.fragment_routine_add_button.*

class RoutineAddButtonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_add_button, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 단순 네비게이션 역할하는 코드이다. MVP 모델을 과하게 적용할 필요가 없어보인다.
        to_routine_add.setOnClickListener {
            val addRoutineDialog = AddRoutineDialog()
            showDialog(addRoutineDialog)
        }
    }
}
