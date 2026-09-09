package com.example.gameslae.modulos.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameslae.databinding.ActivityHomeBinding
import com.example.gameslae.modulos.home.ui.adapter.HomeAdapter
import com.example.gameslae.modulos.home.ui.viewmodel.HomeUiEstado
import com.example.gameslae.modulos.home.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val miAdaptador by lazy { HomeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initRv()
        initObservers()

    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.estado.collect { estado ->
                    dibujaUi(estado)
                }
            }
        }
    }

    fun dibujaUi(estado: HomeUiEstado) {

    }

    private fun initRv() {
        with(binding.rvHome){
            layoutManager = LinearLayoutManager(this@Home)
            adapter = miAdaptador
            setHasFixedSize(true)
        }
    }
}