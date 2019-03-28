package com.develop.greedy0110.mylittlemorningroutine.view

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

interface RoutineSimpleView {
    fun updateLayout(routine: Routine)
    fun goRoutineDetail(routine: Routine)
    fun reflashRoutineSimpleList()
    fun showAddRoutineRecordDialog(routine: Routine)
}