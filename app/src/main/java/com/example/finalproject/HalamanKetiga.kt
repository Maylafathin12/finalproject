package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.data.OrderUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanKetiga(
    viewModel: OrderViewModel = viewModel(),
    onPesanLagiClicked: () -> Unit,
    onDetailClicked: (OrderUIState) -> Unit
) {
    val pesananList by viewModel.pesananList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        PesananList(pesananList, onDeleteClicked = { pesanan ->
            viewModel.removePesanan(pesanan)
        }, onDetailClicked = onDetailClicked)


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
