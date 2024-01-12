package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalproject.data.OrderUIState
import com.example.finalproject.ui.komponen.FormatLabelHarga
import com.example.finalproject.ui.theme.FinalprojectTheme

@Composable
fun HalamanDua(
    orderUIState: OrderUIState,
    onPesanSekarangClicked: () -> Unit,
    onBatalkanPesananClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

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
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = dimensionResource(R.dimen.padding_medium))
        )

        // Tambahkan button untuk Pesan Sekarang dan Batalkan Pesanan
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onBatalkanPesananClicked() },
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .padding(vertical = 8.dp)
            ) {
                Text("Batalkan Pesanan")
            }

            Button(
                onClick = { onPesanSekarangClicked() },
                modifier = Modifier
                    .weight(1f)
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .padding(vertical = 8.dp)
            ) {
                Text("Pesan Sekarang")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanDua() {
    FinalprojectTheme {
        HalamanDua(orderUIState = OrderUIState(),
            onPesanSekarangClicked = { /*TODO*/ },
            onBatalkanPesananClicked = { /*TODO*/ })
    }
}

