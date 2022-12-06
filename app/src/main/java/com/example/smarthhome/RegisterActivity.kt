package com.example.smarthhome

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class RegisterActivity: AppCompatActivity() {

    private lateinit var fullname: EditText
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    private lateinit var signUpButton: Button
    private lateinit var cancelButton: Button

    private var credentials = mapOf("fullname" to "Catana Radu", "username" to "cr7", "email" to "cr7@email.com","password" to "cr7654321")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        initViews()
    }

    private fun initViews() {

        fullname = findViewById(R.id.fullNameEditText)
        username = findViewById(R.id.usernameEditText)
        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.passwordEditText)
        signUpButton = findViewById(R.id.signUpButton)
        cancelButton = findViewById(R.id.cancelButton)

        signUpButton.setOnClickListener {
            if (checkCredentials()) {
                println("REDIRECT TO LOGIN")
            } else {
                println("SHOW ALERT")
            }
        }

        cancelButton.setOnClickListener {
            println("REDIRECT TO LOGIN")
        }

    }

    private fun checkCredentials(): Boolean {
        return fullname.text.equals(credentials["fullname"]) &&
                username.text.equals(credentials["username"]) &&
                email.text.equals(credentials["email"]) &&
                password.text.equals(credentials["password"])
    }
}