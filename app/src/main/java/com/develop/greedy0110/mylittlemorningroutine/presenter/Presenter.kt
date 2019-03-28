package com.develop.greedy0110.mylittlemorningroutine.presenter

// view 에 bind unbind 하는 코드가 중복되니 묶어놓자. T에 해당하는 걸 view 로 한정지으려면 view 공용 인터페이스가 필요하다.
open class Presenter<T>() {
    protected var view:T? = null

    fun bind(view: T) {
        this.view = view
    }

    fun unbind() {
        view = null
    }
}