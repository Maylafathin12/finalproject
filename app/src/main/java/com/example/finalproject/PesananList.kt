package com.example.finalproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalproject.data.OrderUIState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PesananList(
    pesananList: List<OrderUIState>,
    onDeleteClicked: (OrderUIState) -> Unit,
    onDetailClicked: (OrderUIState) -> Unit
) {
    Column {
        pesananList.forEach { pesanan ->
            PesananCard(
                pesanan = pesanan,
                onCardClicked = { onDetailClicked(pesanan) },
                onDeleteClicked = { onDeleteClicked(pesanan) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

