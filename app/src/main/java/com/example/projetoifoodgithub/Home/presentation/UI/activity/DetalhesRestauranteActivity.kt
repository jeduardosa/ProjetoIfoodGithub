package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoifoodgithub.Home.presentation.UI.adapter.Produto
import com.example.projetoifoodgithub.Home.presentation.UI.adapter.Produto2
import com.example.projetoifoodgithub.R
import com.example.projetoifoodgithub.databinding.ActivityDetalhesRestauranteBinding

class DetalhesRestauranteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesRestauranteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesRestauranteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.comboOutback.setOnClickListener {
            val intent = Intent(this, ProductsRequest::class.java)
            startActivity(intent)
        }

        }
    }