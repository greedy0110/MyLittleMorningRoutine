package com.develop.greedy0110.mylittlemorningroutine.presenter

import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineModel
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineSimpleView

class RoutineSimplePresenter(private val model: RoutineModel, private val key: String = "demo"): Presenter<RoutineSimpleView>() {
    fun onActivityCreated() {
        view?.updateLayout(model.getRoutine(key))
    }

    fun showRoutine() {
        view?.goRoutineDetail(model.getRoutine(key))
    }

    fun removeRoutine() {
        model.removeRoutine(key)
        view?.reflashRoutineSimpleList()
    }

    fun addRoutineRecord() {
        view?.showAddRoutineRecordDialog(model.getRoutine(key))
    }
}