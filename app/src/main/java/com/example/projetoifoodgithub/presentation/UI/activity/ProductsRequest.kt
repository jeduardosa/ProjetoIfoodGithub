package com.example.projetoifoodgithub.Home.presentation.UI.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.Login.ConfirmacaoPedidoActivity
import com.example.projetoifoodgithub.databinding.ActivityProductsRequestBinding

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

        //PICLES
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
                binding.txtQuantityQueijo.text =  counterQueijo.toString()
                updateTotal()
        }

        binding.btnQueijoMenos.setOnClickListener {
            if (counterQueijo > 0) {
                counterQueijo--
                binding.txtQuantityQueijo.text = counterQueijo.toString()
                updateTotal()
            }
        }

        binding.btnConfirmar.setOnClickListener {
            val intent = Intent(this, ConfirmacaoPedidoActivity::class.java)
            startActivity(intent)
        }

        //QUANTIDADE TOTAL
        binding.btnQuantityTotalMais.setOnClickListener {
            counterTotal++
            binding.txtQuantityTotal.text = counterTotal.toString()
            updateTotal()
        }

        binding.btnQuantityTotalMenos.setOnClickListener {
            if (counterTotal > 1){
                counterTotal--
                binding.txtQuantityTotal.text = counterTotal.toString()
                updateTotal()
            }
        }
    }

    private fun updateTotal(){
        counterAuxiliar = (counterQueijo*5) + (counterPicles*10)
        val contaTotal = counterAuxiliar + (counterTotal * valorCombo)
        binding.txtPrecoTotalInChangeProducts.text = String.format("RS%20d", contaTotal)
    }

}
