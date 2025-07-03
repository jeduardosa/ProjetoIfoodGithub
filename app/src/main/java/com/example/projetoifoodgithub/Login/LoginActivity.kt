package com.example.projetoifoodgithub.Login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.Home.presentation.UI.activity.HomeActivity
import com.example.projetoifoodgithub.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        logarUsuario()
    }

    private fun logarUsuario() {
        binding.editLoginEmail.text
        binding.editLoginSenha.text

        //adicionar a logica da tela da loja pelo usuario 2 aqui
        binding.btnLogin.setOnClickListener {}
    }


}