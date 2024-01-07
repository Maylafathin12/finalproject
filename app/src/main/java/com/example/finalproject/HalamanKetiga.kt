package com.example.finalproject

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanKetiga(
    viewModel: OrderViewModel = viewModel(),
    onPesanLagiClicked: () -> Unit
) {
    val pesananList by viewModel.pesananList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        pesananList.forEach { pesanan ->
            PesananCard(
                pesanan = pesanan,
                onDeleteClicked = {
                    viewModel.removePesanan(pesanan)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Button to navigate back to HalamanSatu
        Button(
            onClick = { onPesanLagiClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.pesan_lagi))
        }
    }
}
