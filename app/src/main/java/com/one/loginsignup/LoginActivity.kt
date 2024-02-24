package com.one.loginsignup



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val authManager by lazy { AuthManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginButton = findViewById<Button>(R.id.loginButton)
        var emailEditText = findViewById<EditText>(R.id.emailEditText)
        var passwordEditText = findViewById<EditText>(R.id.passwordEditText)



        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            authManager.login(email, password) { success, message ->
                if (success) {
                    // Login successful, navigate to the next screen
                    // Example: startActivity(Intent(this, HomeActivity::class.java))

                    Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show()
                } else {
                    // Login failed, show an error message
                    Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
