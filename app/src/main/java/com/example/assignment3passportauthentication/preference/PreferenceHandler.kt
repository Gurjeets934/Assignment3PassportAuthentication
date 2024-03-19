package com.example.assignment3passportauthentication.preference

import android.content.Context
import android.content.SharedPreferences
import com.example.assignment3passportauthentication.R


class PreferenceHandler (context: Context) {

    private var prefs: SharedPreferences =
        context.getSharedPreferences(
            context.getString(
                R.string.app_name),
                Context.MODE_PRIVATE
        )

    companion object {
        const val USER_TOKEN = "user_token"
    }

    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}