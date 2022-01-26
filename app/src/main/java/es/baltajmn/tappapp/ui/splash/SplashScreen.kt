package es.baltajmn.tappapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import es.baltajmn.tappapp.ui.activity.MainActivity
import es.baltajmn.tappapp.R
import es.baltajmn.tappapp.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.titleSplash.visibility = View.VISIBLE
        binding.iconSplash.visibility = View.VISIBLE

        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.titleSplash.startAnimation(animationFadeIn)
        binding.iconSplash.startAnimation(animationFadeIn)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}