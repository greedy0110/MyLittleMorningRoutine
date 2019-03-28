package com.develop.greedy0110.mylittlemorningroutine.presenter

import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineModel
import com.develop.greedy0110.mylittlemorningroutine.view.RoutineView

class RoutineDisplayPresenter(private val model: RoutineModel, private val key: String = "demo") {

    private var view: RoutineView? = null

    fun bind(view : RoutineView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun onActivityCreated() {
        view?.updateLayout(model.getRoutine(key))
    }
}