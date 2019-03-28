package com.develop.greedy0110.mylittlemorningroutine.view.contract

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

interface RoutineListView {
    fun updateList(routines :List<Routine>)
}