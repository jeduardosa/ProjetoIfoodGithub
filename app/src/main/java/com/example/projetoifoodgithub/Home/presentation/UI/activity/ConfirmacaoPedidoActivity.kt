package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.databinding.ActivityConfirmacaoPedidoBinding

class ConfirmacaoPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmacaoPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmacaoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btnVoltar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

