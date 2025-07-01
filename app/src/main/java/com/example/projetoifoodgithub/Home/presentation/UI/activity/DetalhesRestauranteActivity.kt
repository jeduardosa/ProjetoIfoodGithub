package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.databinding.ActivityDetalhesRestauranteBinding

class DetalhesRestauranteActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetalhesRestauranteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding){
            shapeImagePedido.setOnClickListener {


            }

        }

    }
}