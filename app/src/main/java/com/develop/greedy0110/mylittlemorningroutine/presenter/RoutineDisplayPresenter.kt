package com.develop.greedy0110.mylittlemorningroutine.presenter

import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineModel
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineView

class RoutineDisplayPresenter(private val model: RoutineModel, var key: String = "demo"): Presenter<RoutineView>() {
    fun onActivityCreated() {
        view?.updateLayout(model.getRoutine(key))
    }
}