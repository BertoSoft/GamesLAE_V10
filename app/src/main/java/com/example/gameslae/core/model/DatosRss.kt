package com.example.gameslae.core.model

data class DatosRss (
    val title: String? = null,       // Ej: "La Primitiva: resultados del jueves..."
    val description: String? = null, // Ej: "Combinación ganadora: 05, 12, 19..."
    val pubDate: String? = null,     // Ej: "Thu, 12 Mar 2026 22:00:00 +0100"
    val guid: String? = null
)