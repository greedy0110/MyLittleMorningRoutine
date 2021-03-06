package com.develop.greedy0110.mylittlemorningroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineMemoryModel
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineRoomModel
import com.develop.greedy0110.mylittlemorningroutine.presenter.RoutineListPresenter
import com.develop.greedy0110.mylittlemorningroutine.view.contract.RoutineListView
import kotlinx.android.synthetic.main.activity_routine_simple_list.*
import org.koin.android.ext.android.inject

class RoutineSimpleListActivity : AppCompatActivity(),
    RoutineListView {

    private var lastPos = -1
    private lateinit var adapter: RoutineSimplePagerAdapter
    private val presenter: RoutineListPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_simple_list)

        presenter.bind(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        // 마지막 position 기억하자.
        lastPos = simple_list_view_pager.currentItem
        // 만약 마지막 포지션이 엑티비티 추가하는 곳이였다면 fragmentList의 마지막 녀석으로 세팅하고
        if (lastPos == adapter.count - 1) lastPos = -1
        // 아니라면 해당 position 을 기억
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun updateList(routines: List<Routine>) {
        // 이 엑티비티가 화면에 다시 보여질때마다 Resume 을 호출해서 항상 최근 fragment 상태를 유지하자.
        val fragmentList = makeRoutineSimpleFragmentList(routines)
        adapter = RoutineSimplePagerAdapter(supportFragmentManager, fragmentList)
        simple_list_view_pager.adapter = adapter
        // 첫번째 아이템은 fragmentList 마지막에 있는 녀석으로 만든다.
        if (lastPos == -1)
            simple_list_view_pager.currentItem = fragmentList.size - 1
        else
            simple_list_view_pager.currentItem = lastPos
    }

    private fun makeRoutineSimpleFragmentList(routines: List<Routine>): MutableList<RoutineSimpleFragment> {
        // 모든 routine 에 해당하는 fragment를 만들자.
        // TODO routine 의 정렬 순서는 어떻게 되어야하나?
        val fragmentList = mutableListOf<RoutineSimpleFragment>()
        for (routine in routines) {
            val fragment = RoutineSimpleFragment()
            fragment.key = routine.key
            fragmentList.add(fragment)
        }
        return fragmentList
    }
}

class RoutineSimplePagerAdapter(fm: FragmentManager, var fragmentList: MutableList<RoutineSimpleFragment>) : FragmentStatePagerAdapter(fm) {
    private val routineAddButtonFragment = RoutineAddButtonFragment()

    override fun getItem(position: Int): Fragment {
        if (position < fragmentList.size)
            return fragmentList[position]
        else
            return routineAddButtonFragment
    }

    override fun getCount(): Int {
        // routin simple 들 과 마지막에 새로운 루틴 추가로!
        return fragmentList.size + 1
    }
}