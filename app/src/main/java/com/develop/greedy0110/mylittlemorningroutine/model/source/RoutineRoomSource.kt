package com.develop.greedy0110.mylittlemorningroutine.model.source

import android.content.Context
import androidx.room.Room
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.data.RoutineDBConverter
import com.develop.greedy0110.mylittlemorningroutine.model.data.RoutineRoomDatabase
import com.develop.greedy0110.mylittlemorningroutine.utils.SingletonHolder

class RoutineRoomSource private constructor(context: Context){

    private val db: RoutineRoomDatabase by lazy {  Room.databaseBuilder(
        context,
        RoutineRoomDatabase::class.java, "routine").allowMainThreadQueries().build()
    }

    init {
        // 초기 정보를 불러온다.
        getRoutines()
    }

    private var routines: List<Routine> = mutableListOf()

    fun getRoutines(): List<Routine> {
        routines = db.routineDao().getAll().map { RoutineDBConverter.getRoutine(it) }
        return routines
    }

    fun getRoutine(key: String): Routine {
        return routines.find { it.key == key }?: throw IllegalArgumentException("do't have routine")
    }

    fun addRoutine(routine: Routine) {
        db.routineDao().insertAll(RoutineDBConverter.getRoutineDB(routine))
    }

    fun deleteRoutine(key: String) {
        val routine = getRoutine(key)
        db.routineDao().delete(RoutineDBConverter.getRoutineDB(routine))
    }

    companion object : SingletonHolder<RoutineRoomSource, Context>(::RoutineRoomSource)
}