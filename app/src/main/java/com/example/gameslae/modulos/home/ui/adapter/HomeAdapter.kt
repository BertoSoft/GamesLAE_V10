package com.example.gameslae.modulos.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gameslae.databinding.ItemHomeBinding
import com.example.gameslae.modulos.home.domain.model.DatosHome

class HomeAdapter(): ListAdapter<DatosHome, HomeAdapter.HomeViewHolder>(DiffCallback) {
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
