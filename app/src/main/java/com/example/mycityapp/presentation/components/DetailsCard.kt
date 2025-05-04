package com.example.mycityapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.mycityapp.R

@Composable
fun DetailsCard(imageResId: Int, nameResId: Int, descriptionResId: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Black, shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = stringResource(id = nameResId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(id = nameResId),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = stringResource(id = descriptionResId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun DetailsTitle() {
    Text(
        text = stringResource(id = R.string.details_title),
        style = TextStyle(
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier.padding(top = 20.dp)
    )
}