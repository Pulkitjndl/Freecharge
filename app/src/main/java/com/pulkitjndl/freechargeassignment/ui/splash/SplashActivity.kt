package com.pulkitjndl.freechargeassignment.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.pulkitjndl.freechargeassignment.R
import com.pulkitjndl.freechargeassignment.ui.MainActivity
import com.pulkitjndl.freechargeassignment.ui.dashboard.DashboardActivity
import com.pulkitjndl.freechargeassignment.ui.dashboard.DashboardActivity_MembersInjector

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        Handler().postDelayed({
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}