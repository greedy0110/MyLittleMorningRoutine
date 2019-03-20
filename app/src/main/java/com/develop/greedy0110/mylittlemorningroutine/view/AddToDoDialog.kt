package com.develop.greedy0110.mylittlemorningroutine.view

import android.app.Dialog
import android.content.Context
import android.widget.Button
import com.develop.greedy0110.mylittlemorningroutine.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_routine_detail.view.*

class AddToDoDialog(context: Context) {
    private val dialog by lazy { Dialog(context) }
    var title: TextInputEditText
    var desc: TextInputEditText
    var cancel: Button
    var ok: Button

    init {
        dialog.setContentView(R.layout.add_todo_dialog)

        title = dialog.findViewById(R.id.add_todo_title_edit)
        desc = dialog.findViewById(R.id.add_todo_desc_edit)
        cancel = dialog.findViewById(R.id.add_todo_cancel)
        ok = dialog.findViewById(R.id.add_todo_ok)
    }

    fun show() {
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }
}