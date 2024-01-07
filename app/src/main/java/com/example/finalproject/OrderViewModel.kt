package com.example.finalproject

import androidx.lifecycle.ViewModel
import com.example.finalproject.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val  HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI:StateFlow<OrderUIState> = _stateUI.asStateFlow()
    private val _pesananList = MutableStateFlow<List<OrderUIState>>(emptyList())
    val pesananList: StateFlow<List<OrderUIState>> = _pesananList.asStateFlow()


    fun setJumlah(jmlEsJumbo:Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }
    }

    fun setMenu(menuPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(menu = menuPilihan)
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    fun removePesanan(pesanan: OrderUIState) {
        _pesananList.value = _pesananList.value.toMutableList().apply {
            remove(pesanan)
        }
    }

    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }
    fun setContact(listData:  MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                alamat = listData[1],
                telepon = listData[2]
            )
        }
    }
}

