package br.com.acvt.motivacao.data.repository

import android.content.Context

class MotivationShared(private val mContext: Context) {

    private val mSharedPreferences =
        mContext.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String) = mSharedPreferences.getString(key, "")

    companion object {
        val KEY_USERNAME = "name"
    }
}