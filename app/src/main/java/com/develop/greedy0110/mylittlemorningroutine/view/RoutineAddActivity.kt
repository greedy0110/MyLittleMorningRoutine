package com.develop.greedy0110.mylittlemorningroutine.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.data.ToDo
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRepository
import com.develop.greedy0110.mylittlemorningroutine.utils.hideKeyboard
import com.develop.greedy0110.mylittlemorningroutine.utils.showDialog
import com.develop.greedy0110.mylittlemorningroutine.view.dialog.AddToDoDialog
import khronos.Dates
import kotlinx.android.synthetic.main.activity_routine_add.*
import org.jetbrains.anko.toast

class RoutineAddActivity : AppCompatActivity() {
    val adapter = AddNewToDoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_add)

        new_todo_list.layoutManager = LinearLayoutManager(applicationContext)
        new_todo_list.adapter = adapter

        newtodo_add.setOnClickListener {
            // TODO를 추가하는 Dialog 를 띄워줌
            // Dialog 의 OK 버튼을 누르면 TODO를 TODOLIST에 추가함
            // Dialog 의 Cancel 버튼을 누르면 Dialog 를 닫음
            val dialog = AddToDoDialog()
            dialog.adapter = adapter
            showDialog(dialog)
        }

        new_routine_ok.setOnClickListener {
            // 현재 activity 의 정보들이 valid 한지 검사
            if (!routineInfoValid()) return@setOnClickListener

            // 현재 정보들로 새로운 Routine 객체 생성
            val routine = makeRoutine()

            // Routine 객체를 model 에 저장
            RoutineRepository.addRoutine(routine)

            // activity 를 마무리
            finish()
        }

        new_routine_x.setOnClickListener {
            // TODO 나갈지 말지 dialog 띄워줌

            // activity 를 마무리
            finish()
        }
    }

    // 꼭 필요한 정보
    // routine title, 적어도 한개 이상의 todo_list
    private fun routineInfoValid():Boolean {
        if (new_routine_name_edit.text.toString().isBlank()) {
            toast("루틴 이름을 입력해주세요.")
            return false
        }

        if (adapter.data.isEmpty()) {
            toast("루틴 할일을 추가해주세요.")
            return false
        }

        return true
    }

    private fun makeRoutine() = Routine(
        title = new_routine_name_edit.text.toString(),
        desc = new_routine_desc_edit.text.toString(),
        isWeekDay = new_is_weekday.isChecked,
        startDate = Dates.today,
        toDoList = adapter.data
    )
}
