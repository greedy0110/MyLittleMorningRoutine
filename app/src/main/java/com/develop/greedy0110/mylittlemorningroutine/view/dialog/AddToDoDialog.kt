package com.develop.greedy0110.mylittlemorningroutine.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.develop.greedy0110.mylittlemorningroutine.R
import com.develop.greedy0110.mylittlemorningroutine.model.data.ToDo
import com.develop.greedy0110.mylittlemorningroutine.view.AddNewToDoAdapter
import com.google.android.material.textfield.TextInputEditText
import java.lang.IllegalStateException

class AddToDoDialog: DialogFragment() {
    var adapter: AddNewToDoAdapter? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = activity?.layoutInflater?.inflate(R.layout.add_todo_dialog, null)

        return AlertDialog.Builder(activity).run {
            setTitle("할 일 추가")
            setView(dialogView)
            setPositiveButton("OK") {
                dialog, which ->
                adapter?.apply {
                    val title = dialogView?.findViewById<TextInputEditText>(R.id.add_todo_title_edit)?.text.toString()
                    val desc = dialogView?.findViewById<TextInputEditText>(R.id.add_todo_desc_edit)?.text.toString()

                    if (title.isBlank()) return@setPositiveButton

                    addData(ToDo(title = title, desc = desc))
                }
            }
            setNegativeButton("Cancel") {
                dialog, which ->
            }
            create()
        } ?: throw IllegalStateException()
    }
}