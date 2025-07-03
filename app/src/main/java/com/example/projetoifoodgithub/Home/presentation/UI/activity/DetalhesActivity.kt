package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
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