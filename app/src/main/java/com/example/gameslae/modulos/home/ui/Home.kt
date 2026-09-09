package com.example.gameslae.modulos.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameslae.databinding.ActivityHomeBinding
import com.example.gameslae.core.utils.Utils
import com.example.gameslae.modulos.home.ui.adapter.HomeAdapter
import com.example.gameslae.modulos.home.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Home : AppCompatActivity() {

    @Inject lateinit var utils: Utils
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val miAdaptador by lazy { HomeAdapter(utils) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initRv()
        initObservers()
        viewModel.initApp()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.estado.collect { estado ->
                    miAdaptador.submitList(estado.lista)
                }
            }
        }
    }

    private fun initRv() {
        with(binding.rvHome){
            layoutManager = LinearLayoutManager(this@Home)
            adapter = miAdaptador
            setHasFixedSize(true)
        }
    }
}