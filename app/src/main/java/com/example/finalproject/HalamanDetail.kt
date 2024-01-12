package com.example.finalproject

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject.data.OrderUIState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDetail(
    detailPesanan: OrderUIState,
    onUpdateClicked: (OrderUIState) -> Unit,
    navController: NavController
) {
    var updatedNama by remember { mutableStateOf(detailPesanan.nama) }
    var updatedAlamat by remember { mutableStateOf(detailPesanan.alamat) }
    var updatedTelepon by remember { mutableStateOf(detailPesanan.telepon) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Detail Pesanan")
        Spacer(modifier = Modifier.height(16.dp))

        // Display existing details
        Text("Nama Pelanggan: ${detailPesanan.nama}")
        Text("Alamat: ${detailPesanan.alamat}")
        Text("Telepon: ${detailPesanan.telepon}")
        Text("Menu: ${detailPesanan.menu}")
        Text("Jumlah: ${detailPesanan.jumlah}")
        Text("Harga: ${detailPesanan.harga}")

        Spacer(modifier = Modifier.height(16.dp))

        // Form to update details
        OutlinedTextField(
            value = updatedNama,
            onValueChange = { updatedNama = it },
            label = { Text("Nama Pelanggan") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = updatedAlamat,
            onValueChange = { updatedAlamat = it },
            label = { Text("Alamat") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = updatedTelepon,
            onValueChange = { updatedTelepon = it },
            label = { Text("Telepon") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to update details
        Button(
            onClick = {
                onUpdateClicked(
                    detailPesanan.copy(
                        nama = updatedNama, alamat = updatedAlamat, telepon = updatedTelepon
                    )
                )
                // Display toast notification for a successful update
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()

                // Navigate back to the previous screen
                navController.popBackStack()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(text = "Update Informasi")
        }
    }
}
