package com.develop.greedy0110.mylittlemorningroutine.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.showDialog(dialog: DialogFragment) {
    dialog.show(activity!!.supportFragmentManager, dialog::class.java.name)
}

fun AppCompatActivity.showDialog(dialog: DialogFragment) {
    dialog.show(supportFragmentManager, dialog::class.java.name)
}