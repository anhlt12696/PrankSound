package com.prank.sound.hair.cut.ps.pranksound.utils

import android.app.Application
import android.util.Log
import com.dungvnhh98.percas.studio.admoblib.admob.AdmobManager
import com.dungvnhh98.percas.studio.admoblib.admob.AppResumeAdsManager
import com.prank.sound.hair.cut.ps.pranksound.Activity.SplashActivity
import com.prank.sound.hair.cut.ps.pranksound.R

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RemoteConfig().initRemoteConfig()
        AdmobManager.initAdmob(this, timeOut = 10000, true, true)

        if(RemoteConfig().isEnableAOA()){
            AppResumeAdsManager.getInstance().init(this,AdsUtils.ADS_OPEN.toString())
            AppResumeAdsManager.getInstance().disableAppResumeWithActivity(SplashActivity::class.java)
        }

        //init adjust
        AdjustManager.initAdjust(this, getString(R.string.adjust_token), false)

    }
}