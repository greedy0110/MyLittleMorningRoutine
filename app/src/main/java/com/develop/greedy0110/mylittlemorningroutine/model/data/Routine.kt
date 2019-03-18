package com.develop.greedy0110.mylittlemorningroutine.model.data

import com.develop.greedy0110.mylittlemorningroutine.model.KeyGenerator
import khronos.Dates
import java.util.Date // java.util.Date 는 시/분/초 까지 가져올 수 있다고 한다.

data class Routine(
    var title : String = "title",
    var desc : String = "desc",
    var isWeekDay : Boolean = true, // TODO 통일된 (주간 주말 구분없는) 루틴일 수도 있다.
    var startDate : Date = Dates.today,
    val key: String = KeyGenerator.getRandomKey(), // 생성시 랜덤 키를 생성해서 할당 변하지 않음
    var toDoList : MutableList<ToDo> = mutableListOf(),
    var records : MutableList<RoutineRecord> = mutableListOf()
) {
    data class RoutineRecord(
        val toDoList : MutableList<ToDo> = mutableListOf(),
        // to do check list 는 to do list 에서 to do 를 수행했는지 여부를 기록한다.
        val toDoCheckList: MutableList<Boolean> = MutableList<Boolean>(toDoList.size, {false}),
        val date : Date = Dates.today
    ) {
        val achieve // 한 일 갯수 / 모닝 루틴 전체 갯수 * 100
            get() = toDoCheckList.count { it } / toDoCheckList.size.toFloat() * 100
    }

    val achieve: Float
        get() {
            if (records.isEmpty()) return 0f
            else {
                var sum = 0f
                records.forEach { sum += it.achieve }
                return sum / records.size
            }
        }

    fun makeRecord(date: Date = Dates.today) = RoutineRecord(toDoList = toDoList, date = date)
}

