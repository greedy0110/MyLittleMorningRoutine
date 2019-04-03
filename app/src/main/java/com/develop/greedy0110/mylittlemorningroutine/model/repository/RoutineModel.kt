package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

interface RoutineModel {
    fun getRoutines(): List<Routine>
    fun getRoutine(key: String): Routine
    fun removeRoutine(key: String)
    fun addRoutine(d: Routine)
}