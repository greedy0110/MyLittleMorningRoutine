package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.source.RoutineMemorySource

class RoutineMemoryModel : RoutineModel {
    override fun getRoutines(): List<Routine> {
        return RoutineMemorySource.routines.map { it -> it.value }
    }

    override fun getRoutine(key: String): Routine {
        return RoutineMemorySource.routines[key]?:throw IllegalStateException()
    }

    override fun removeRoutine(key: String) {
        RoutineMemorySource.deleteRoutine(key)
    }

    override fun addRoutine(d: Routine) {
        RoutineMemorySource.addRoutine(d)
    }
}