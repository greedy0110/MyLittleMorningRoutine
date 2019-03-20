package com.develop.greedy0110.mylittlemorningroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRepository
import kotlinx.android.synthetic.main.activity_routine.*

class RoutineActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)

        // demo routine 데이터
        //val key = "demo"
        val key = intent.getStringExtra("key")
        val routine = RoutineRepository.routines.get(key)

        if (routine == null) {
            // TODO 잘못된 key 라는 것을 알려야함
            finish()
            return
        }

        view_pager.adapter = RoutinePagerAdapter(supportFragmentManager, 2, routine)
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

class RoutinePagerAdapter(fm: FragmentManager, private val tabCount: Int, routine: Routine) : FragmentStatePagerAdapter(fm) {
    private val routineDF = RoutineDetailFragment()
    private val routineRF = RoutineRecordFragment()

    init {
        routineDF.routine = routine; routineRF.routine = routine
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