package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine

class RoutineMemoryModel : RoutineModel {
    override fun getRoutine(key: String): Routine {
        return RoutineRepository.routines[key]?:throw IllegalStateException()
    }

    override fun removeRoutine(key: String) {
        RoutineRepository.deleteRoutine(key)
    }
}