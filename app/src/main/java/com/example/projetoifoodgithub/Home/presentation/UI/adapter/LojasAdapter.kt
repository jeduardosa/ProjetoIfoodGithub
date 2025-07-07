package com.example.projetoifoodgithub.Home.presentation.UI.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projetoifoodgithub.Home.data.model.Loja
import com.example.projetoifoodgithub.Home.presentation.UI.activity.DetalhesRestauranteActivity
import com.example.projetoifoodgithub.databinding.ItemRvLojasBinding
import com.example.projetoifoodgithub.databinding.ItemRvUltimasLojasBinding
import com.squareup.picasso.Picasso

class LojasAdapter(
    private val orientacao: Int,
): RecyclerView.Adapter<ViewHolder>() {

    private var listaLojas = listOf<Loja>()
    fun adicionarLista(lista: List<Loja>) {
        listaLojas = lista
        notifyDataSetChanged()
    }

    inner class LojasViewHolder(
        private val binding: ItemRvLojasBinding
    ) : ViewHolder(binding.root) {
        fun bind(loja: Loja) {
            with(binding) {
                textTituloLoja.text = loja.nome
                textCategoriaLoja.text = loja.categoria
                if (loja.urlImagem.isNotEmpty()) {
                    Picasso.get()
                        .load(loja.urlImagem)
                        .into(imageLoja)
                }
                clLoja.setOnClickListener {
                    val intent = Intent(itemView.context, DetalhesRestauranteActivity::class.java)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    inner class UltimasLojasViewHolder(
        private val binding: ItemRvUltimasLojasBinding
    ) : ViewHolder(binding.root) {
        fun bind(loja: Loja) {
            with(binding) {
                textTituloUltimaLoja.text = loja.nome
                if (loja.urlImagem.isNotEmpty()) {
                    Picasso.get()
                        .load(loja.urlImagem)
                        .into(imageUltimaLoja)
                }
                clUltimaLoja.setOnClickListener {
                    val intent = Intent(itemView.context, DetalhesRestauranteActivity::class.java)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        if (orientacao == RecyclerView.VERTICAL) {
            val itemLojasBinding = ItemRvLojasBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return LojasViewHolder(itemLojasBinding)
        }
        val itemUltimasLojasBinding = ItemRvUltimasLojasBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return UltimasLojasViewHolder(itemUltimasLojasBinding)
    }

    override fun getItemCount(): Int {
        return listaLojas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val loja = listaLojas[position]
        when (holder) {
            is LojasViewHolder -> holder.bind(loja)
            is UltimasLojasViewHolder -> holder.bind(loja)

        }
    }
}