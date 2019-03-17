package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

// 모든 루틴 정보를 가지고 있어야 한다
object RoutineRepository {
    val routines = mutableMapOf<String,Routine>()
}