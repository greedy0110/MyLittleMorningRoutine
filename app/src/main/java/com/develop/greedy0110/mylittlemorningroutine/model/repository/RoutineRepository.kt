package com.develop.greedy0110.mylittlemorningroutine.model.repository

import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.data.ToDo

// 모든 루틴 정보를 가지고 있어야 한다
object RoutineRepository {
    val routines = mutableMapOf<String,Routine>()

    init {
        // demo data
        val toDoList = mutableListOf(
            ToDo(title = "이부자리 정리"), ToDo(title = "머리, 세안", desc = "구와아악 안하면 더럽자너"), ToDo(title = "책 읽기", desc = "지금은 린 스타트업 20 분 정도씩 읽자"),
            ToDo(title = "산책", desc = "정신 차리는데는 바깥 공기맞는거 만한게 없지")
        )
        val checkList = MutableList(toDoList.size, {true})
        routines["demo"] = Routine(
            key = "demo",
            title = "나작모",
            desc = "이건 실험용 routine 데이터",
            isWeekDay = false,
            toDoList = toDoList,
            records = mutableListOf(
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList),
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList),
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList)
            )
        )

        val toDoList2 = mutableListOf(
            ToDo(title = "이부자리 정리"), ToDo(title = "머리, 세안", desc = "구와아악 안하면 더럽자너"), ToDo(title = "책 읽기", desc = "지금은 린 스타트업 20 분 정도씩 읽자"),
            ToDo(title = "산책", desc = "정신 차리는데는 바깥 공기맞는거 만한게 없지")
        )
        val checkList2 = MutableList(toDoList.size, {true})
        routines["demo2"] = Routine(
            key = "demo2",
            title = "나작모22",
            desc = "이건 실험용 routine 데이터",
            isWeekDay = false,
            toDoList = toDoList,
            records = mutableListOf(
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList),
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList),
                Routine.RoutineRecord(toDoList = toDoList, toDoCheckList = checkList)
            )
        )
    }

    fun addRoutine(routine: Routine) {
        routines[routine.key] = routine
    }
}