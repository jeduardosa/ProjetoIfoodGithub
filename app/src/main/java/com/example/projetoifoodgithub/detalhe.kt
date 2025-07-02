package com.example.projetoifoodgithub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoifoodgithub.databinding.ActivityDetalheBinding

class detalhe : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetalheBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        val imagem = intent.getIntExtra("imagem", 0)
        val nome = intent.getStringExtra("nome")
        val preco = intent.getStringExtra("preco")
        val avaliacao = intent.getStringExtra("avaliacao")

        binding.apply {
            imgDetalhe.setImageResource(imagem)
            nomeDetalhe.text = nome
            precoDetalhe.text = preco
            avaliacaoDetalhe.text = "Avaliação: $avaliacao"
        }

    }
}