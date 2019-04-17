package com.develop.greedy0110.mylittlemorningroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineMemoryModel
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRoomModel
import com.develop.greedy0110.mylittlemorningroutine.presenter.RoutineDisplayPresenter
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineView
import kotlinx.android.synthetic.main.activity_routine.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RoutineActivity : AppCompatActivity(), RoutineView {

    private val presenter: RoutineDisplayPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)

        // demo routine 데이터
        //val key = "demo"
        val key = intent.getStringExtra("key")
        presenter.key = key
        presenter.bind(this)
        presenter.onActivityCreated()

    }

    override fun updateLayout(routine: Routine) {
        view_pager.adapter = RoutinePagerAdapter(supportFragmentManager, 2, routine.key)
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab?.position?:0
            }
        })
    }
}

class RoutinePagerAdapter(fm: FragmentManager, private val tabCount: Int, key: String) : FragmentStatePagerAdapter(fm) {
    private val routineDF = RoutineDetailFragment()
    private val routineRF = RoutineRecordFragment()

    init {
        routineDF.key = key; routineRF.key = key
    }

    override fun getItem(pos: Int): Fragment {
        return when (pos) {
            0 -> routineDF
            1 -> routineRF
            else -> routineDF
        }
    }

    override fun getCount(): Int = tabCount
}