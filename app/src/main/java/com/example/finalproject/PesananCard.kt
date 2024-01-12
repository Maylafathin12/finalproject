package com.example.finalproject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalproject.data.OrderUIState
import com.example.finalproject.ui.theme.FinalprojectTheme

@Composable
fun PesananCard(
    pesanan: OrderUIState,
    onDeleteClicked: () -> Unit,
    onCardClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCardClicked() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Pelanggan: ${pesanan.nama}")
            Text(text = "Menu: ${pesanan.menu}")
            Text(text = "Jumlah: ${pesanan.jumlah}")
            Text(text = "Harga: ${pesanan.harga}")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onDeleteClicked) {
                    Icon(Icons.Default.Delete, contentDescription = "Hapus")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPesananCard() {
    FinalprojectTheme {
        PesananCard(
            pesanan = OrderUIState(),
            onCardClicked = { /*TODO*/ },
            onDeleteClicked = { /*TODO*/ })
    }
}
