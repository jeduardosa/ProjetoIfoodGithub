package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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





