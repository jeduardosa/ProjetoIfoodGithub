package com.example.projetoifoodgithub.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.Home.presentation.UI.activity.HomeActivity
import com.example.projetoifoodgithub.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val validEmail = "123"
    private val validPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validaConta()
        }
    }

    private fun validaConta(){
        val email = binding.editLoginEmail.text.toString().trim()
        val password = binding.editLoginSenha.text.toString().trim()

        when {
            email.isEmpty() -> {
                Toast.makeText(this, "Digite seu e-mail", Toast.LENGTH_SHORT).show()
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Digite sua senha", Toast.LENGTH_SHORT).show()
            }
            email != validEmail || password != validPassword ->{
                Toast.makeText(this, "Usuário ou Senha inválidos", Toast.LENGTH_SHORT).show()
            }
            else -> dasboardSeries()
        }
    }

    private fun dasboardSeries(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}