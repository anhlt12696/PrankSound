package com.prank.sound.hair.cut.ps.pranksound.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prank.sound.hair.cut.ps.pranksound.R
import com.prank.sound.hair.cut.ps.pranksound.databinding.ActivityFeedbackBinding
import com.prank.sound.hair.cut.ps.pranksound.utils.AdsUtils
import com.prank.sound.hair.cut.ps.pranksound.utils.BaseActivity

class FeedbackActivity : BaseActivity() {
    private lateinit var binding: ActivityFeedbackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            AdsUtils.loadAndShowInterstitialAd(
                this,
                AdsUtils.interAdHolder,
                object : AdsUtils.loadAndShow {
                    override fun onAdClose() {
                        onBackPressed()
                    }

                    override fun onAdFailed() {
                        onBackPressed()
                    }

                })

        }



        binding.llBtnSend.setOnClickListener {
            if(binding.edFeedback.text.isNullOrBlank()){
                Toast.makeText(this,"Please enter your feedback",Toast.LENGTH_LONG).show()
            }else{
                onBackPressed()
            }

        }
    }
}