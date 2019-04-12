package com.develop.greedy0110.mylittlemorningroutine.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRoomModel
import com.develop.greedy0110.mylittlemorningroutine.model.source.RoutineMemorySource
import com.develop.greedy0110.mylittlemorningroutine.utils.showDialog
import com.develop.greedy0110.mylittlemorningroutine.view.adapter.AddNewToDoAdapter
import khronos.Dates
import org.jetbrains.anko.toast

class AddRoutineDialog: DialogFragment() {
    lateinit var routine_title: TextView
    lateinit var routine_desc: TextView
    lateinit var is_weekday: RadioButton
    lateinit var todo_list: RecyclerView
    lateinit var todo_add: Button

    val adapter = AddNewToDoAdapter()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.add_routine_dialog, null)
        view.run {
            routine_title = findViewById(R.id.new_routine_name_edit)
            routine_desc = findViewById(R.id.new_routine_desc_edit)
            is_weekday = findViewById(R.id.new_is_weekday)
            todo_list = findViewById(R.id.new_todo_list)
            todo_add = findViewById(R.id.newtodo_add)

            todo_list.layoutManager = LinearLayoutManager(activity)
            todo_list.adapter = adapter

            todo_add.setOnClickListener {
                // TODO를 추가하는 Dialog 를 띄워줌
                // Dialog 의 OK 버튼을 누르면 TODO를 TODOLIST에 추가함
                // Dialog 의 Cancel 버튼을 누르면 Dialog 를 닫음
                val dialog = AddToDoDialog()
                dialog.adapter = adapter
                showDialog(dialog)

                // TODO todo 추가한 이후에 스크롤을 제일 아래로 내려야해
            }
        }

        return AlertDialog.Builder(activity).run {
            setTitle(R.string.add_routine_title)
            setView(view)
            setPositiveButton(R.string.ok_text, null)
            setNegativeButton(R.string.cancel_text, null)
            create().apply {
                // 조건에 맞지 않는경우 dismiss를 예방하기 위해서 코딩을 이런식으로 한다.
                setOnShowListener {
                    val pos = getButton(AlertDialog.BUTTON_POSITIVE)
                    pos.setOnClickListener  {
                        // 현재 activity 의 정보들이 valid 한지 검사
                        if (!routineInfoValid()) return@setOnClickListener

                        // 현재 정보들로 새로운 Routine 객체 생성
                        val routine = makeRoutine()

                        // Routine 객체를 model 에 저장
                        RoutineRoomModel(activity!!.applicationContext).addRoutine(routine)

                        // dialog 를 명시적으로 꺼줘야한다.
                        dismiss()
                    }

                    val neg = getButton(AlertDialog.BUTTON_NEGATIVE)
                    neg.setOnClickListener {
                        showDialog(YesOrNoDialog().apply {
                            titleId = R.string.do_you_exit_routine_maker
                            listener = object : YesOrNoDialog.ButtonListener {
                                override fun clickYes() {
                                    this@AddRoutineDialog.dismiss()
                                }

                                override fun clickNo() {
                                }
                            }
                        })
                    }
                }
            }
        } ?: throw IllegalStateException("Add Routine Dialog Error")
    }

    // 꼭 필요한 정보
    // routine title, 적어도 한개 이상의 todo_list
    private fun routineInfoValid():Boolean {
        if (routine_title.text.toString().isBlank()) {
            activity?.toast("루틴 이름을 입력해주세요.")
            return false
        }

        if (adapter.data.isEmpty()) {
            activity?.toast("루틴 할일을 추가해주세요.")
            return false
        }

        return true
    }

    private fun makeRoutine() = Routine(
        title = routine_title.text.toString(),
        desc = routine_desc.text.toString(),
        isWeekDay = is_weekday.isChecked,
        startDate = Dates.today,
        toDoList = adapter.data
    )

    // 종료되면 액티비티를 다시 그려준다.
    override fun onDestroy() {
        super.onDestroy()
        activity?.run {
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
}