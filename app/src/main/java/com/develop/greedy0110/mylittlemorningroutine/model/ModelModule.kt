package com.develop.greedy0110.mylittlemorningroutine.model

import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineMemoryModel
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineModel
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRoomModel
import org.koin.dsl.module

val modelModule = module {
    single<RoutineModel> { RoutineRoomModel(get()) }
}

// 메모리 테스트용
val memoryModelModule = module {
    single<RoutineModel> { RoutineMemoryModel() }
}