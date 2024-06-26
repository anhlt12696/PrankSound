package com.prank.sound.hair.cut.ps.pranksound.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prank.sound.hair.cut.ps.pranksound.model.Record

object Utils {

    fun setVibration(context: Context, open: Boolean) {
        val preferences =
            context.getSharedPreferences(context.packageName, Context.MODE_MULTI_PROCESS)
        preferences.edit().putBoolean("KEY_VIBRATION", open).apply()
    }

    fun getVibration(context: Context): Boolean {
        val preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        return preferences.getBoolean("KEY_VIBRATION", true)
    }

    // Lưu danh sách vào SharedPreferences
    fun saveAudioList(context: Context, audioFileList: List<Record>) {
        val sharedPreferences = context.getSharedPreferences("audio_list", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val json = Gson().toJson(audioFileList)
        editor.putString("audio_list", json)
        editor.apply()
    }

    // Lấy danh sách từ SharedPreferences
    fun getAudioList(context: Context): List<Record> {
        val sharedPreferences = context.getSharedPreferences("audio_list", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("audio_list", null)
        val type = object : TypeToken<List<Record>>() {}.type
        return Gson().fromJson(json, type) ?: emptyList()
    }
}