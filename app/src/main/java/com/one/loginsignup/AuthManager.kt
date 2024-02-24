package com.one.loginsignup

// AuthManager.kt

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth

class AuthManager(private val activity: Activity) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signUp(email: String, password: String, callback: (Boolean, String) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    callback(true, "Sign up successful")
                } else {
                    callback(false, "Sign up failed: ${task.exception?.message}")
                }
            }
    }

    fun login(email: String, password: String, callback: (Boolean, String) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    callback(true, "Login successful")
                } else {
                    callback(false, "Login failed: ${task.exception?.message}")
                }
            }
    }
}
