package com.example.projetoifoodgithub.Home.presentation.UI.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.models.SlideModel
import com.example.projetoifoodgithub.Home.data.model.FiltroCategoria
import com.example.projetoifoodgithub.Home.data.model.Loja
import com.example.projetoifoodgithub.Home.presentation.UI.adapter.FiltroCategoriaAdapter
import com.example.projetoifoodgithub.Home.presentation.UI.adapter.LojasAdapter
import com.example.projetoifoodgithub.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val listaFiltroCategoria = listOf(
        FiltroCategoria(
            "Restaurantes",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Restaurantes3_JO1o.png?imwidth=256"
        ),
        FiltroCategoria(
            "Mercado",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Mercados_nlXp.png?imwidth=256"
        ),
        FiltroCategoria(
            "Farmacia",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Farmacia_Nosz.png?imwidth=256"
        ),
        FiltroCategoria(
            "Pet",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Pet_e9dU.png?imwidth=256"
        ),
        FiltroCategoria(
            "Bebidas",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Bebidas_x2Lk.png?imwidth=256"
        ),
        FiltroCategoria(
            "Shopping",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/floreseperfume_zTRv.png?imwidth=256"
        ),
        FiltroCategoria(
            "Gourmet",
            "https://static.ifood-static.com.br/image/upload/t_medium/discoveries/Gourmet_RQ4A.png?imwidth=256"
        ),
        FiltroCategoria(
            "Japonesa",
            "https://cms-cdn.saipos.com/assets/2025/03/07/4-tipos-de-sushi-SAIPOS-sistema-para-restaurantes_uid_67caf6b6c522b.png"
        )
    )

    private lateinit var lojasAdapter: LojasAdapter
    private lateinit var ultimasLojasAdapter: LojasAdapter

    private val lojas = listOf(
        Loja(
            "Mc Donald's ",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/9ba12409-83c1-4f10-bff8-c6d2f0ff2a36/202408251256_10ZR.png?imwidth=128"
        ),
        Loja(
            "OutBack Steakhouse",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_thumbnail/logosgde/49c13948-f7fc-461a-b00a-9453989f9d66/202209261023_d3XS_i.jpg?imwidth=128"
        ),
        Loja(
            "Pizza Big Mike",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/0e11bca1-cdcd-42bc-a531-bd2470ff3803/202002010055_iuUW_i.jpg?imwidth=128"
        ),
        Loja(
            "Pizza Mais",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/4c9906e8-d468-4999-8fb6-e397c8f5b277/202001141045_GDPl_i.jpg?imwidth=128"
        ),
        Loja(
            "Los Frangos",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/0415699b-a920-4b98-943b-5020edbebbc5/202101250116_l4xE_i.png?imwidth=128"
        ),
        Loja(
            "LANCHES DO CEARÁ",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/f0bfbaa9-1f49-4238-9c3c-cb818d65e01c/202406031121_nY0P_i.jpg?imwidth=128"
        ),
        Loja(
            "Dogão Maluco",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/079cdf5c-bca5-49a4-b4f1-6d851ad68c6e/202411252202_kLAh_i.jpg?imwidth=128"
        ),
        Loja(
            "Rei do Açaí ",
            "Açai",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/8d1711c5-22d0-4142-bcf5-dca3419d0310/202408271157_9Lgb_i.jpg?imwidth=128"
        ),
        Loja(
            "Pizza La Páprika",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/a5a3d1d9-658c-4c47-87d8-4c95d18f5edb/202406281602_WCXU_i.jpg?imwidth=128"
        ),
        Loja(
            "Come Come Pizzaria",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/de1a7dcf-aab9-4a23-aaec-5f6d471b59a7/202501101657_GHJo_i.jpg?imwidth=128"
        ),
        Loja(
            "La Casa da Pizza",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/6329d1a2-f10b-48ab-9f44-a512646a2a8b/202404172009_QHep_i.jpg?imwidth=128"
        ),
        Loja(
            "Grupo Batistella",
            "Carnes",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/da67874c-bf06-4d65-8f4b-8abd1a797b40/202204201755_PgzU_i.jpg?imwidth=128"
        ),
        Loja(
            "Big Lanche",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/d22c8685-a7e4-43b3-b19a-fb380920fc6d/202408292025_JRAK_i.jpg?imwidth=128"
        ),
        Loja(
            "Salt N'pizza",
            "Pizza",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/24693801-786d-4961-af17-fc5a0640c90e/202207081214_vdW1_i.jpg?imwidth=128"
        ),
        Loja(
            "Galito Frito",
            "Lanches",
            "https://static.ifood-static.com.br/image/upload/t_medium/logosgde/62a545e4-332f-4824-9f45-1e7976559255/202212262050_SVRN_i.jpg?imwidth=128"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        inicializarFiltroCategorias()
        inicializarSlider()
        inicializarLojas()
        inicializarUltimasLojas()
    }

    private fun inicializarFiltroCategorias() {
        with(binding) {
           val filtroCategoria = FiltroCategoriaAdapter()
            rvFiltroCategoria.adapter = filtroCategoria
            rvFiltroCategoria.layoutManager = GridLayoutManager(
                this@HomeActivity,
                4
            )

            filtroCategoria.adicionarItens(listaFiltroCategoria)
        }
    }

    private fun inicializarSlider() {

        val listaSlides = ArrayList<SlideModel>()
        listaSlides.add(
            SlideModel(
                "https://static.ifood-static.com.br/image/upload/t_high/discoveries/18946capaprincipal11_nNFs.png?imwidth=3840"
            )
        )
        listaSlides.add(
            SlideModel(
                "https://static.ifood-static.com.br/image/upload/t_high/discoveries/18284principalsuper_WD1i.png?imwidth=3840"
            )
        )
        listaSlides.add(
            SlideModel(
                "https://static.ifood-static.com.br/image/upload/t_high/discoveries/17498principalbec31_yhYq.png?imwidth=3840"
            )
        )

        binding.imageSlider.setImageList(listaSlides)
    }

    private fun inicializarUltimasLojas() {
        with(binding){
            val orientacao = RecyclerView.HORIZONTAL
            ultimasLojasAdapter = LojasAdapter(orientacao)
            ultimasLojasAdapter.adicionarLista(lojas)
            rvUltimasLojas.adapter = ultimasLojasAdapter
            rvUltimasLojas.layoutManager = LinearLayoutManager(
                this@HomeActivity, orientacao, false
            )
        }
    }

    private fun inicializarLojas() {
        with(binding){
            val orientacao = RecyclerView.VERTICAL
            lojasAdapter = LojasAdapter(orientacao)
            lojasAdapter.adicionarLista(lojas)
            rvLojas.adapter = lojasAdapter
            rvLojas.layoutManager = LinearLayoutManager(
                this@HomeActivity, orientacao, false
            )
        }
    }
}