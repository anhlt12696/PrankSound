package com.prank.sound.hair.cut.ps.pranksound.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dungvnhh98.percas.studio.admoblib.admob.AppOpenAdsManager
import com.google.android.gms.ads.AdValue
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.prank.sound.hair.cut.ps.pranksound.R
import com.prank.sound.hair.cut.ps.pranksound.databinding.ActivitySplashBinding
import com.prank.sound.hair.cut.ps.pranksound.utils.BaseActivity

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_TIME_OUT: Long = 4000 // milliseconds
    private val handler = Handler()

    private var key: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        handler.postDelayed({
            // Tạo Intent để chuyển sang màn hình mới
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Đóng Activity hiện tại để không thể quay lại màn hình Splash bằng nút Back
            finish()
        }, SPLASH_TIME_OUT)



    }



    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            // Tạo Intent để chuyển sang màn hình mới
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Đóng Activity hiện tại để không thể quay lại màn hình Splash bằng nút Back
            finish()
        }, SPLASH_TIME_OUT)
    }
    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
