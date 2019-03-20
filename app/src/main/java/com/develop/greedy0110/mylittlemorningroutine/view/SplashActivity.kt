package com.develop.greedy0110.mylittlemorningroutine.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.develop.greedy0110.mylittlemorningroutine.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 1초후에 앱 메인으로
        Handler().postDelayed({
            val intent = Intent(applicationContext, RoutineSimpleListActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}
