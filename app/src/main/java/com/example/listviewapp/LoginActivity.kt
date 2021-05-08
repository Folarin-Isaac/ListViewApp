package com.example.listviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // button opens the next activity and calls the function to validate user inputs
        binding?.buttonLogin?.setOnClickListener {
            verifyUserCredentials()
        }

    }
    // To verify if the input fields are empty or have the default email and password

    private fun verifyUserCredentials() {
        val email = binding?.editEmailAddress?.editText?.text.toString()
        val password = binding?.editPassword?.editText?.text.toString()

        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Both fields are required!!", Toast.LENGTH_LONG).show()
        } else if (email.equals("folarinisaac36@gmail.com", true) && password == "Hyzic") {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Invalid login credentials.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}