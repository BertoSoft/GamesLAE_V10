package com.example.gameslae.modulos.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gameslae.databinding.ItemHomeBinding
import com.example.gameslae.core.utils.Utils
import com.example.gameslae.modulos.home.domain.model.DatosHome
import com.example.gameslae.modulos.home.domain.model.TipoSorteo

class HomeAdapter(
    private val utils: Utils
): ListAdapter<DatosHome, HomeAdapter.HomeViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewHolder {
        // 🔄 Inflamos el layout específico de la celda usando su propio Binding
        val binding = ItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = getItem(position)
        holder.render(item)
    }

    inner class HomeViewHolder(
        private val binding: ItemHomeBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun render(datos: DatosHome){
            var strFecha = ""
            if(datos.fecha != null){
                strFecha = utils.fromLocalDateToFechaLarga(datos.fecha)
            }
            val strTvFecha = "Sorteo Nº: ${datos.numeroSorteo}, ${strFecha}"
            val listaNumeros = datos.numeros

            // Primitiva
            if(datos.tipoSorteo == TipoSorteo.Primitiva && datos.numeros != null){
                with(binding){
                    tvBola1.text = listaNumeros[0].toString()
                    tvBola2.text = listaNumeros[1].toString()
                    tvBola3.text = listaNumeros[2].toString()
                    tvBola4.text = listaNumeros[3].toString()
                    tvBola5.text = listaNumeros[4].toString()
                    tvBola6.text = listaNumeros[5].toString()

                    tvBola8.text = listaNumeros[6].toString()
                    tvBola9.text = listaNumeros[7].toString()
                }
            }

        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<DatosHome>() {
        override fun areItemsTheSame(oldItem: DatosHome, newItem: DatosHome): Boolean {
            return oldItem.fecha == newItem.fecha
        }

        override fun areContentsTheSame(oldItem: DatosHome, newItem: DatosHome): Boolean {
            return oldItem == newItem
        }
    }
}
