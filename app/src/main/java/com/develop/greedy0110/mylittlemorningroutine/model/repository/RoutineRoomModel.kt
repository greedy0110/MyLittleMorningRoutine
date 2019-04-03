package com.develop.greedy0110.mylittlemorningroutine.model.repository

import android.content.Context
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.source.RoutineRoomSource

class RoutineRoomModel(private val context: Context): RoutineModel {
    override fun getRoutines(): List<Routine> {
        return RoutineRoomSource.getInstance(context).getRoutines()
    }

    override fun getRoutine(key: String): Routine {
        return RoutineRoomSource.getInstance(context).getRoutine(key)
    }

    override fun removeRoutine(key: String) {
        RoutineRoomSource.getInstance(context).deleteRoutine(key)
    }

    override fun addRoutine(d: Routine) {
        RoutineRoomSource.getInstance(context).addRoutine(d)
    }
}