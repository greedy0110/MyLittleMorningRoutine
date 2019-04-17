package com.develop.greedy0110.mylittlemorningroutine.presenter

import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val presenterModule = module {
    factory { RoutineDisplayPresenter(get()) }
    factory { RoutineListPresenter(get()) }
    factory { RoutineSimplePresenter(get()) }
}