package com.example.rickandmortyapp.data.remote.models

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)