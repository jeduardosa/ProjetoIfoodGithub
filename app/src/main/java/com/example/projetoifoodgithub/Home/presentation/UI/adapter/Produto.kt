package com.example.projetoifoodgithub.Home.presentation.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoifoodgithub.R
import com.example.projetoifoodgithub.databinding.ProdutoBinding

data class Produto(
    val imagemResId: Int,
    val nome: String,
    val preco: String,
    val avaliacao: String
)

class Produto2(
    private val produtoList: List<Produto>,
    private val onItemClick: (Produto) -> Unit
) : RecyclerView.Adapter<Produto2.ProdutoViewHolder>() {

    inner class ProdutoViewHolder(val binding: ProdutoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val binding = ProdutoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtoList[position]
        holder.binding.apply {
            imgProduto.setImageResource(produto.imagemResId)
            priceTxt.text = produto.preco
            titleTxt.text = produto.nome
            ratingTxt.text = produto.avaliacao
        }

        holder.itemView.setOnClickListener {
            onItemClick(produto)
        }
    }

    override fun getItemCount() = produtoList.size
}