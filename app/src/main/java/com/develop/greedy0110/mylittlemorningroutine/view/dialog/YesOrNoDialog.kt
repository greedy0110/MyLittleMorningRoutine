package com.develop.greedy0110.mylittlemorningroutine.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.develop.greedy0110.mylittlemorningroutine.R

// titleId 를 지정해서 caption 을 달자.
// listener 를 지정해서 응답에 반응하자.
class YesOrNoDialog: DialogFragment() {
    interface ButtonListener {
        fun clickYes()
        fun clickNo()
    }

    var titleId: Int? = null
    var listener: ButtonListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity).run {
            titleId?.let { setTitle(it) }
            setPositiveButton(R.string.ok_text) {
                dialog, pos ->
                listener?.clickYes()
            }
            setNegativeButton(R.string.cancel_text) {
                dialog, pos ->
                listener?.clickNo()
            }
            create()
        }
    }
}