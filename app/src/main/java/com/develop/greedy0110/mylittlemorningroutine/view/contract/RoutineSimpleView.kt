package com.develop.greedy0110.mylittlemorningroutine.view.contract

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

interface RoutineSimpleView: RoutineView {
    fun goRoutineDetail(routine: Routine)
    fun refreshRoutineSimpleList()
    fun showAddRoutineRecordDialog(routine: Routine)
}

