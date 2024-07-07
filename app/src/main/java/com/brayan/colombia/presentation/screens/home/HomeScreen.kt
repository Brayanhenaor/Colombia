package com.brayan.colombia.presentation.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.brayan.colombia.R
import com.brayan.colombia.presentation.common.base.BaseScreen
import com.brayan.colombia.presentation.common.text.BodyText
import com.brayan.colombia.presentation.common.text.HeadingText
import com.brayan.colombia.ui.theme.ColombiaTheme

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
){
    BaseScreen(
        viewModel = homeViewModel,
        load = { homeViewModel.loadData() },
        content = {
            HomeScreenBody(
                navController,
                homeViewModel
            )
        }
    ) {
        Text(text = "Cargando")
    }
}

@Composable
private fun HomeScreenBody(
    navController: NavController,
    homeViewModel: HomeViewModel
){
    var showMoreInfo by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(ColombiaTheme.colors.black.copy(alpha = 0.4f))
        )

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp,
                        vertical = 15.dp)
            ) {
                HeadingText(text = homeViewModel.countryData?.name?.uppercase() ?:"")

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = homeViewModel.countryData?.stateCapital ?: "")
                Text(text = homeViewModel.countryData?.subRegion ?: "")
            }

            Box(
                modifier = Modifier
                    .offset(y = 20.dp)
                    .fillMaxWidth()
                    .clickable {
                        showMoreInfo = !showMoreInfo
                    }
                    .background(
                        ColombiaTheme.colors.green,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(
                        top = 20.dp,
                        bottom = 30.dp,
                        start = 15.dp,
                        end = 15.dp
                    )
            ){
                Column {
                    HeadingText(text = "Más info")
                    AnimatedVisibility(visible = showMoreInfo) {
                        BodyText(text = homeViewModel.countryData?.description ?: "")
                    }
                }
            }

            MenuSlider(
                color = Color.White,
                offset = (10).dp
            ){
                CategoryItem(
                    navController,
                    "Sitios turisticos",
                    color = Color.Black
                )
            }

            MenuSlider(
                color = ColombiaTheme.colors.darkBlue,
                offset = (0).dp
            ){
                CategoryItem(
                    navController,
                    "Especies invasoras",
                    color = Color.White
                )
            }
        }
        

    }
}

@Composable
private fun CategoryItem(
    navController: NavController,
    text: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .clickable {
                navController.navigate("touristic")
            }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeadingText(text = text, color = color)
            Icon(
                Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "",
                tint = color,
                modifier = Modifier
                    .height(40.dp)
            )
        }
    }
}

@Composable
private fun MenuSlider(
    color: Color,
    offset: Dp,
    content: @Composable ()-> Unit
){
    Box(
        modifier = Modifier
            .offset(y = (offset))
            .fillMaxWidth()
            .background(
                color,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            )
            .padding(
                top = 20.dp,
                bottom = 30.dp,
                start = 20.dp,
                end = 20.dp
            )
    ){
        content()
    }
}