package com.one.loginsignup

// SignUpActivity.kt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    private val authManager by lazy { AuthManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var signUpButton = findViewById<Button>(R.id.signUpButton)
        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            authManager.signUp(email, password) { success, message ->
                if (success) {
                    // Sign up successful, navigate to the login screen
                    // Example: startActivity(Intent(this, LoginActivity::class.java))
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                } else {
                    // Sign up failed, show an error message
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
