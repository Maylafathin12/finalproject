@file:OptIn(ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class)

package com.example.finalproject

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.data.SumberData.drink


enum class PengelolaHalaman {
    Home,
    Menu,
    Summary,
    Formulir,
    Ketiga
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalProjectAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (bisaNavigasiBack) {
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalProjectApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            FinalProjectAppBar(
                bisaNavigasiBack = false,
                navigasiUp = {
                    // TODO: Implement back navigation
                }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Formulir.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Formulir.name) {
                val context = LocalContext.current
                HalamanPembeli(
                    onSubmitButtonClick = {
                        viewModel.setContact(it)
                        navController.navigate(PengelolaHalaman.Menu.name)
                    },
                    onCancelButtonClick = {
                        cancelOrderAndNavigateToHome(
                            viewModel,
                            navController,
                        )
                    }
                )
            }
            composable(route = PengelolaHalaman.Menu.name) {
                val context = LocalContext.current
                HalamanSatu(
                    pilihanMenu = drink.map { id ->
                        context.resources.getString(id)
                    },
                    onSelectionChanged = { viewModel.setMenu(it) },
                    onConfirmButtonClicked = { viewModel.setJumlah(it) },
                    onNextButtonClicked = { navController.navigate(PengelolaHalaman.Summary.name)
                    },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToHome(
                            viewModel,
                            navController
                        )
                    }
                )
            }
            composable(route = PengelolaHalaman.Summary.name) {
                HalamanDua(
                    orderUIState = uiState,
                    onPesanSekarangClicked = {
                        navController.navigate(PengelolaHalaman.Ketiga.name)
                    },
                    onBatalkanPesananClicked = {
                        navController.popBackStack(PengelolaHalaman.Formulir.name, inclusive = false)
                    }
                )
            }
            composable(route = PengelolaHalaman.Ketiga.name) {
                HalamanKetiga(
                    viewModel = viewModel,
                    onPesanLagiClicked = {
                        navController.navigate(PengelolaHalaman.Home.name)
                    }
                )
            }

        }
    }
}


// cancelOrderAndNavigateToHome function

private fun cancelOrderAndNavigateToHome(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(PengelolaHalaman.Home.name, inclusive = false)
}
private fun cancelOrderAndNavigateToMenu (
    navController: NavHostController
){
    navController.popBackStack (PengelolaHalaman.Menu.name, inclusive
    = false)

}