package com.develop.greedy0110.mylittlemorningroutine.presenter

import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineModel
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineListView

class RoutineListPresenter(private val model: RoutineModel): Presenter<RoutineListView>() {
    fun onResume() {
        view?.updateList(model.getRoutines())
    }
}