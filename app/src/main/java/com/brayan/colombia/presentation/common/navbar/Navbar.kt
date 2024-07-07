package com.brayan.colombia.presentation.common.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.brayan.colombia.ui.theme.ColombiaTheme

@Composable
fun Navbar(
    navController: NavController
){
    Row(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(55.dp)
            .background(ColombiaTheme.colors.green)
            .padding(horizontal = 10.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "")
        }
    }
}