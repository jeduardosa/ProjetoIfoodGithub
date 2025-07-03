package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.databinding.ActivityProductsRequestBinding
import java.text.NumberFormat
import java.util.Locale

class ProductsRequest : AppCompatActivity() {
    private lateinit var binding: ActivityProductsRequestBinding
    private var counterPicles = 0
    private var counterQueijo = 0
    private var counterTotal = 1
    private var counterAuxiliar = 0
    private val valorCombo = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnPiclesMais.setOnClickListener {
            counterPicles++
            binding.txtQuantityPicles.text = counterPicles.toString()
            updateTotal()
        }

        binding.btnPiclesMenos.setOnClickListener {
            if (counterPicles > 0) {
                counterPicles--
                binding.txtQuantityPicles.text = counterPicles.toString()
                updateTotal()
            }
        }

        //QUEIJO
        binding.btnQueijoMais.setOnClickListener {
            counterQueijo++
            binding.txtQuantityQueijo.text = counterQueijo.toString()
            updateTotal()
        }

        binding.btnQueijoMenos.setOnClickListener {
            if (counterQueijo > 0) {
                counterQueijo--
                binding.txtQuantityQueijo.text = counterQueijo.toString()
                updateTotal()
            }
        }

        //QUANTIDADE TOTAL
        binding.btnQuantityTotalMais.setOnClickListener {
            counterTotal++
            binding.txtQuantityTotal.text = counterTotal.toString()
            updateTotal()
        }

        binding.btnQuantityTotalMenos.setOnClickListener {
            if (counterTotal > 1) {
                counterTotal--
                binding.txtQuantityTotal.text = counterTotal.toString()
                updateTotal()
            }
        }

        binding.btnConfirmar.setOnClickListener {
            val valorTotal = binding.txtPrecoTotalInChangeProducts.text.toString()
            val intent = Intent(this, ConfirmacaoPedidoActivity::class.java)
            intent.putExtra("CARRINHO", valorTotal)
            startActivity(intent)
        }
    }

    private fun updateTotal() {
        counterAuxiliar = (counterQueijo * 5) + (counterPicles * 10)
        val contaTotal = counterAuxiliar + (counterTotal * valorCombo)

        val formatoMoeda = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        binding.txtPrecoTotalInChangeProducts.text = formatoMoeda.format(contaTotal.toDouble())
    }
}