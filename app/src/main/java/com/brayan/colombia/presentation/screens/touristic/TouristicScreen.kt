package com.brayan.colombia.presentation.screens.touristic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.brayan.colombia.domain.model.Touristic
import com.brayan.colombia.presentation.common.base.BaseScreen
import com.brayan.colombia.presentation.common.navbar.Navbar
import com.brayan.colombia.presentation.common.text.HeadingText

@Composable
fun TouristicScreen(
    navController: NavController,
    touristicViewModel: TouristicViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BaseScreen(
            viewModel = touristicViewModel,
            load = { touristicViewModel.loadData() },
            content = {
                TouristicScreenBody(
                    touristicViewModel,
                    navController
                )
            }
        ) {
            Text(text = "Cargando")
        }
    }
}

@Composable
fun TouristicScreenBody(
    touristicViewModel: TouristicViewModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .safeDrawingPadding()
    ) {
        Navbar(
            navController
        )

        LazyColumn(
            modifier = Modifier
                .safeDrawingPadding()
        ) {
            items(touristicViewModel.touristicPlaces?.size ?: 0) {
                val item = touristicViewModel.touristicPlaces?.get(it)
                item?.let {
                    TouristicItem(
                        it
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun TouristicItem(
    item: Touristic
){
    val configuration = LocalConfiguration.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(horizontal = 10.dp)
        .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = item.images.firstOrNull() ?: "",
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )
        HeadingText(
            text = item.name,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 10.dp)
        )
    }
}