package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.finalproject.data.OrderUIState
import com.example.finalproject.ui.komponen.FormatLabelHarga

@Composable
fun HalamanDua(
    orderUIState: OrderUIState,
    onPesanSekarangClicked: () -> Unit,
    onBatalkanPesananClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Tampilkan data pelanggan
        Text(text = "Nama: ${orderUIState.nama}")
        Text(text = "Alamat: ${orderUIState.alamat}")
        Text(text = "Telepon: ${orderUIState.telepon}")

        // Tampilkan orderan yang dipilih dan jumlah
        Text(text = "Order: ${orderUIState.menu}")
        Text(text = "Jumlah: ${orderUIState.jumlah}")

        // Tampilkan total biaya
        FormatLabelHarga(
            subtotal = orderUIState.harga,
            modifier = Modifier.align(Alignment.End)
        )

        // Tambahkan button untuk Pesan Sekarang dan Batalkan Pesanan
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(R.dimen.padding_medium)),
                onClick = { onPesanSekarangClicked() }
            ) {
                Text("Pesan Sekarang")
            }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(R.dimen.padding_medium)),
                onClick = { onBatalkanPesananClicked() }
            ) {
                Text("Batalkan Pesanan")
            }
        }
    }
}