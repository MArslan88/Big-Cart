package com.mhdarslan.bigcart.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.mhdarslan.bigcart.R

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()

        val mainImage = findViewById<ImageView>(R.id.mainLogo)

        mainImage.startAnimation(
            AnimationUtils.loadAnimation(
                applicationContext, R.anim.fade_in
            )
        )

        handler.postDelayed(Runnable {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }
}