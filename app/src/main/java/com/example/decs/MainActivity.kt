package com.example.decs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.decs.ui.theme.DecsTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.decs.ui.theme.TitleColor
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.decs.ui.theme.RowdiesFontFamily
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource


val OvalShape = GenericShape { size, _ ->
    addOval(androidx.compose.ui.geometry.Rect(0f, 0f, size.width, size.height))
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DecsTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    AudioScreen()

                }
            }
        }
    }
}

@Composable
fun MojPlayer() {
    var whenPlay by remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(36.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 680.dp)
            .clip(CircleShape)

    ) {

    Image(
        painterResource(id = R.drawable.audioback),
        contentDescription = "audio_back",
        modifier = Modifier
            .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
            .border(4.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
            .clickable {  }
            .size(64.dp)
            .padding(10.dp)
    )
    Image(
        painterResource(id = if (whenPlay) R.drawable.audiopause else R.drawable.audioplay),
        contentDescription = "audio_back",
        modifier = Modifier
            .clickable {
                whenPlay = !whenPlay
            }
            .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
            .border(4.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
            .clickable {  }
            .size(80.dp)
            .padding(5.dp)
    )
    Image(
        painterResource(id = R.drawable.audionext),
        contentDescription = "audio_next",
        modifier = Modifier
            .clickable {  }
            .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
            .border(4.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
            .clickable {  }
            .size(64.dp)
            .padding(10.dp)
    )
}

}
@Composable
fun MyScreen() {
    val backgroundclear = painterResource(id = R.drawable.background_player_clear)
    val backgroundcolordark = Color(0xFF27292A)
    val album_image = painterResource(id = R.drawable.vinyl)
    val titlesong = stringResource(id = R.string.title_song)
    val authorsong = stringResource(id = R.string.author_song)
    val title_actual = stringResource(id = R.string.actual_song)
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundcolordark),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = backgroundclear,
            contentDescription = null,
            modifier = Modifier
                .size(width = 450.dp, height = 800.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
    Box(
        modifier = Modifier.fillMaxWidth()
            .offset(y=160.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title_actual,
            color = Color.White,
            fontSize = 15.sp,
            fontFamily = RowdiesFontFamily,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.titleMedium
        )
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) { Spacer(modifier = Modifier.height(225.dp))
        Image(
            painter = album_image,
            contentDescription = "Album photo",
            modifier = Modifier
                .size(300.dp)
                .clip(OvalShape)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = titlesong,
            color = TitleColor,
            fontSize = 35.sp,
            fontFamily = RowdiesFontFamily,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = authorsong,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = RowdiesFontFamily,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.titleSmall
        )



    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(220.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 150.dp)

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
                .border(3.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
                .clip(CircleShape)
                .clickable { }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.backicon),
                contentDescription = "list_podcast",
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)

            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
                .border(3.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
                .clickable {
                    val intent = Intent(context, ListSongActivity::class.java)
                    context.startActivity(intent)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.listicon),
                contentDescription = "list_podcast",
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )
        }
    }


}




@Preview(showBackground = true)
@Composable
fun AudioScreen() {
    DecsTheme {
        MyScreen()
        MojPlayer()
    }
}