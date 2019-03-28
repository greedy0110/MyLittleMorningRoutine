package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

interface RoutineModel {
    fun getRoutine(key: String): Routine
    fun removeRoutine(key: String)
}