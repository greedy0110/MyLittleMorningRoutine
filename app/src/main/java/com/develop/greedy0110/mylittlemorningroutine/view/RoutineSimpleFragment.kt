package com.develop.greedy0110.mylittlemorningroutine.view


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.Routine
import com.develop.greedy0110.mylittlemorningroutine.model.repository.RoutineMemoryModel
import com.develop.greedy0110.mylittlemorningroutine.presenter.RoutineSimplePresenter
import com.develop.greedy0110.mylittlemorningroutine.utils.showDialog
import com.develop.greedy0110.mylittlemorningroutine.view.dialog.AddRoutineRecordDialog
import khronos.toString
import kotlinx.android.synthetic.main.fragment_routine_simple.*

/**
 * A simple [Fragment] subclass.
 * 루틴의 간단한 정보를 보여줌
 * 루틴 세부정보로 링크되어서 세부 정보를 확인 할 수 있음
 */
class RoutineSimpleFragment : Fragment(), RoutineSimpleView {

    var key: String = "demo"
    private lateinit var presenter: RoutineSimplePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routine_simple, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = RoutineSimplePresenter(RoutineMemoryModel(), key)
        presenter.bind(this)
        presenter.onActivityCreated()

        // routine 을 클릭하면 상세 루틴 정보 페이지로 이동하자.
        routine_simple_layout.setOnClickListener {
            presenter.showRoutine()
        }

        routine_simple_delete.setOnClickListener {
            // TODO 루틴 삭제할지 물어본다. Dialog 정리후 제작하자.
            // 삭제한다고 하면 삭제후 RoutineSimpleListActivity를 다시 그려야한다. (해당 루틴을 삭제하면 이 프래그먼트는 필요가 없어진다.)
            presenter.removeRoutine()
        }

        routine_simple_record.setOnClickListener {
            // 루틴 기록 추가 팝업을 킨다.
            presenter.addRoutineRecord()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun updateLayout(routine: Routine) {
        routine_simple_title.text = routine.title
        routine_simple_desc.text = routine.desc
        routine_simple_date.text = routine.startDate.toString("yyyy.MM.dd ~")
        routine_simple_achieve.text = "성취도 : ${routine.achieve} %"
    }

    override fun goRoutineDetail(routine: Routine) {
        val intent = Intent(activity, RoutineActivity::class.java)
        intent.putExtra("key", routine.key)
        startActivity(intent)
    }

    override fun reflashRoutineSimpleList() {
        val intent = Intent(activity, RoutineSimpleListActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT) // 이 플래그를 줘야 새로운 activity를 만드는 것이 아니라 이미 메모리에 적재된 activity를 그대로 가져온다.
        startActivity(intent)
    }

    override fun showAddRoutineRecordDialog(routine: Routine) {
        val addRoutineRecord = AddRoutineRecordDialog()
        addRoutineRecord.routine = routine
        showDialog(addRoutineRecord)
    }
}
