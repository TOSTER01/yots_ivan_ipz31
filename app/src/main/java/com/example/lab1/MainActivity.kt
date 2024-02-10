package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                }
            }
        }
    }
}

@Composable
fun TextHeader(modifier: Modifier = Modifier) {
    Text(
        text = "Settings",
        fontSize = 36.sp,
        modifier = modifier
            .padding(top = 15.dp, bottom = 23.dp)
    )
}

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.girl_photo),
        contentDescription = stringResource(id = R.string.profile_pictuire_description),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(51.dp)
            .clip(CircleShape)
    )
}


@Composable
fun AboutDevice(modifier: Modifier = Modifier) {
    Row (modifier = Modifier
        .padding(15.dp)) {
        Image(
            painter = painterResource(id = R.drawable.device_settings_icon),
            contentDescription = stringResource(id = R.string.device_settings_description),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 12.dp, bottom = 11.dp, end = 16.dp)
        )
        Column (modifier = Modifier
                .alpha(0.6f)) {
            Text(
                text = "Get to know your Pixel",
                fontSize = 21.sp
            )
            Text(
                text = "Explore what you can do with your phone",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun SearchInput(modifier: Modifier = Modifier) {
    Row (modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = stringResource(id = R.string.search_picture_description),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 11.dp)
        )
        Column (modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp)) {
            Text(
                text = "Search Settings...",
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1Theme{
        Column (modifier = Modifier
                .padding(start = 21.dp, end = 21.dp)) {
            Row (modifier = Modifier
                .align(alignment = Alignment.End)
                .padding(top = 48.dp)) {
                ProfilePicture()
            }
            TextHeader()
            Row (modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xFFDBEA8D))) {
                AboutDevice()
            }
            Row (modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = Color(0xFFFDFCF7))) {
                SearchInput()
            }
        }
    }
}