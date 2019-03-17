package com.develop.greedy0110.mylittlemorningroutine.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRepository

class RoutineActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)

//        val key = intent.getStringExtra("key")
//        val routine = RoutineRepository.routines.get(key)
//
//        if (routine == null) {
//            // TODO 잘못된 key 라는 것을 알려야함
//            finish()
//            return
//        }

        val routineDF = RoutineDetailFragment()
        routineDF.routine = Routine(
            title = "나작모",
            desc = "이건 실험용 routine 데이터",
            isWeekDay = false
        )
        supportFragmentManager.beginTransaction().replace(android.R.id.content, routineDF).commit()
    }
}
