package com.develop.greedy0110.mylittlemorningroutine.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRepository
import java.lang.IllegalStateException

class AddRoutineRecordDialog : DialogFragment() {
    var routine = Routine()

    private val selectedItems = mutableListOf<Int>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        selectedItems.clear()

        return AlertDialog.Builder(activity).run {
            setTitle("${routine.title} 기록하기") // TODO 이런 타이틀은 어떤식으로 리소스를 사용해 관리할 수 있을까?
            setMultiChoiceItems(routine.toDoList.map { it.title as CharSequence }.toTypedArray(),
                BooleanArray(routine.toDoList.size, {false})) {
                dialog, which, isChecked ->
                if (isChecked) {
                    selectedItems.add(which)
                } else if (selectedItems.contains(which)) {
                    selectedItems.remove(which)
                }
            }
            setPositiveButton(R.string.ok_text) {
                dialog, which ->
                val record = routine.makeRecord()
                record.toDoCheckList.fill(false)
                for (i in selectedItems) record.toDoCheckList[i] = true
                RoutineRepository.routines[routine.key]?.records?.add(record)
            }
            setNegativeButton(R.string.cancel_text) {
                dialog, which ->
            }
            create()
        } ?: throw IllegalStateException()
    }
}