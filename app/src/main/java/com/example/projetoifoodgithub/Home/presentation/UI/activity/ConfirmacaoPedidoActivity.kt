package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoifoodgithub.databinding.ActivityConfirmacaoPedidoBinding
import java.text.NumberFormat
import java.util.Locale

class ConfirmacaoPedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmacaoPedidoBinding
    val taxaDelivery = 6.90

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmacaoPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btnVoltar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val subTotal = intent.getStringExtra("CARRINHO")?: "R$ 0,00"
        binding.textSubtotal.text = subTotal

        val taxaDelivery = binding.textTaxaDelivery.text.toString()
        val valorSubTotal = subTotal.replace("R$", "").replace(",", ".").trim().toDoubleOrNull() ?: 0.0
        val valorTaxaDelivery = taxaDelivery.replace("R$", "").replace(",", ".").trim().toDoubleOrNull() ?: 0.0
        val total = valorSubTotal + valorTaxaDelivery
        val formatoMoeda = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        binding.textTotal.text = formatoMoeda.format(total)

        binding.btnConfirmarFinalActivity.setOnClickListener {
            Toast.makeText(this, "Compra confirmada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

