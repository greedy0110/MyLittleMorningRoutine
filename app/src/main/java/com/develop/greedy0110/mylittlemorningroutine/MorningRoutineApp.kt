package com.develop.greedy0110.mylittlemorningroutine

import android.app.Application
import com.develop.greedy0110.mylittlemorningroutine.model.memoryModelModule
import com.develop.greedy0110.mylittlemorningroutine.model.modelModule
import com.develop.greedy0110.mylittlemorningroutine.presenter.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MorningRoutineApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MorningRoutineApp)
            modules(appModules)
        }
    }
}
// model 객체를 영속성 있는 실제 구동 앱에 사용할때
var appModules = listOf(
    modelModule,
    presenterModule
)

// model 객체를 메모리상의 더미 데이터로  테스트 할
var debugModules = listOf(
    memoryModelModule,
    presenterModule
)