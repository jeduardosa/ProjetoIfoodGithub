package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoifoodgithub.Home.data.model.Produto
import com.example.projetoifoodgithub.Home.presentation.UI.adapter.Produto2
import com.example.projetoifoodgithub.R
import com.example.projetoifoodgithub.databinding.ActivityDetalhesRestauranteBinding

class DetalhesRestauranteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesRestauranteBinding
    private lateinit var produtoAdapter: Produto2
    private val autoScrollHandler = Handler(Looper.getMainLooper())
    private var autoScrollPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesRestauranteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val produtoList = listOf(
            Produto(R.drawable.frango_especial, "Frango Especial", "R$ 25,90", "4.5"),
            Produto(R.drawable.ned_kelly, "Combo Hamburgue\n+ Batata + Milk Shake", "R$ 28,90", "4.7"),
            Produto(R.drawable.image_hamburger, "Hamburguer da Casa", "R$ 30,00", "4.8"),
            Produto(R.drawable.big_five, "Big Five", "R$ 32,50", "4.6"),
            Produto(R.drawable.destaque_thuner, "Thunder Browniev", "R$ 21,99", "4.3"),
            Produto(R.drawable.baunilha_gran, "Sorvete Baunilha", "R$ 21,99", "4.3")
        )
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.imgBigFive.setOnClickListener {
            startActivity(Intent(this, ProductsRequest::class.java))
        }

        produtoAdapter = Produto2(produtoList) { produto ->
            Toast.makeText(this, "Clicou em: ${produto.nome}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetalhesActivity::class.java).apply {
                 putExtra("imagem", produto.imagemResId)
                 putExtra("nome", produto.nome)
                 putExtra("preco", produto.preco)
                 putExtra("avaliacao", produto.avaliacao)
             }
             startActivity(intent)
        }

        binding.viewProduto.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.viewProduto.adapter = produtoAdapter

        startAutoScroll(produtoList.size)
    }

    private fun startAutoScroll(produtosSize: Int) {
        autoScrollHandler.postDelayed(object : Runnable {
            override fun run() {
                if (autoScrollPosition >= produtosSize) {
                    autoScrollPosition = 0
                }
                binding.viewProduto.smoothScrollToPosition(autoScrollPosition++)
                autoScrollHandler.postDelayed(this, 4000)
            }
        }, 4000)
    }
}


