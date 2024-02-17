package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ImgView (imgsrc: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imgsrc),
            contentDescription = "img",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun ImgDescription(imgName: String, imgArtist: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = imgName)
            Text(text = imgArtist)
        }
    }
}

@Composable
fun ButtonsUnderText(
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(top = 10.dp)) {
            Button(
                onClick = { onPreviousClicked() },
                modifier = Modifier.padding(end = 20.dp)
            ) {
                Text("Previous")
            }
            Button(
                onClick = { onNextClicked() }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        var imgIndex by remember { mutableStateOf(0) }
        val imgArr = arrayOf(
            R.drawable.pes,
            R.drawable.panda,
            R.drawable.drakon
        )

        val textOneArr = arrayOf(
            "Pes",
            "Panda",
            "Drakon"
        )

        val textScndArr = arrayOf(
            "Pes artist",
            "Panda artist",
            "Drakon artist"
        )

        Column(modifier = Modifier.padding(top = 40.dp, bottom = 40.dp)) {
            ImgView(imgArr[imgIndex])
            ImgDescription(textOneArr[imgIndex], textScndArr[imgIndex])
            ButtonsUnderText(
                onNextClicked = { if (imgIndex < imgArr.size - 1) imgIndex++ else imgIndex = 0 },
                onPreviousClicked = { if (imgIndex > 0) imgIndex-- else imgIndex = 2 }
            )
        }
    }
}
