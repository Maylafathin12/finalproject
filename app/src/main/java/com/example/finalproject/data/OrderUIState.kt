package com.example.finalproject.data

import java.util.UUID

data class OrderUIState(
    val id: String = UUID.randomUUID().toString(),
    val jumlah: Int = 0,
    val menu: String = "",
    val harga: String ="",
    val nama: String ="",
    val alamat: String ="",
    val telepon: String =""
)

