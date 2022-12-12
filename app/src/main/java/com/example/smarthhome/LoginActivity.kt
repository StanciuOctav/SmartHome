package com.example.smarthhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class LoginActivity : AppCompatActivity() {

    private lateinit var textViewUsername:TextView
    private lateinit var textViewPass:TextView
    private lateinit var textViewWrongCredidenials:TextView
    private lateinit var editTextUsername:EditText
    private lateinit var editTextPass:EditText
    private lateinit var textViewSuccessful: TextView
    private lateinit var textViewWrongUsername:TextView
    private lateinit var textViewWrongPass:TextView

    private lateinit var loginButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        val signUp = findViewById<TextView>(R.id.textViewSignUp)
        signUp.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
        initializeViews();
    }

    private fun initializeViews(){
        textViewUsername=findViewById(R.id.textViewUsername)
        editTextUsername=findViewById(R.id.editTextUsername)
        textViewPass=findViewById(R.id.textViewPass)
        editTextPass=findViewById(R.id.editTextPass)
        textViewWrongCredidenials=findViewById(R.id.textViewWrongCredidentials)
        textViewWrongUsername=findViewById(R.id.textViewWrongUsername)
        textViewWrongPass=findViewById(R.id.textViewWrongPass)
        textViewSuccessful=findViewById(R.id.textViewSuccessfulLogin)
        loginButton=findViewById(R.id.signinButton)
    }

    fun loginClick (view: View) {

        var user = editTextUsername.text.toString();
        var pass = editTextPass.text.toString();
        textViewWrongUsername.text = ""
        textViewWrongPass.text = ""
        textViewWrongCredidenials.text = ""
        textViewSuccessful.text = ""

        if (user.equals( "admin") && pass.equals( "password"))
        {
            textViewSuccessful.text = "Successful login"
           startActivity(Intent(this,HomePage::class.java))
        }

        else if (isValidCredidentials(user,pass))
        {

            if (user != "admin" || pass != "password")
                textViewWrongCredidenials.text = "WRONG USERNAME OR PASSWORD"
        }

        else
        {
            if (emptyUsername(user))
                textViewWrongUsername.text = "Username cannot be empty"
            else if (lengthUsername(user))
                textViewWrongUsername.text = "Username must have at least 3 characters"

            if (emptyPass(pass))
                textViewWrongPass.text = "Password cannot be empty"
            else if (lengthPass(pass))
                textViewWrongPass.text = "Password must have at least 6 characters"

        }
    }

    private fun isValidCredidentials(user:String, pass:String): Boolean {
        return !emptyUsername(user) && !emptyPass(pass)
                && !lengthUsername(user) && !lengthPass(pass);
    }

    private fun emptyUsername(user:String): Boolean {
        return user== ""}

    private fun emptyPass(pass:String): Boolean {
        return pass== ""}

    private fun lengthPass(pass:String): Boolean {
        return  pass.length <6
    }

    private fun lengthUsername(user:String): Boolean {
        return  user.length <3
    }
}