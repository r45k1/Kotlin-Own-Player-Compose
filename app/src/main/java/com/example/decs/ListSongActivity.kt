package com.example.decs

import androidx.compose.ui.layout.ContentScale
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.decs.ui.theme.DecsTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.decs.ui.theme.RowdiesFontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.res.colorResource

class ListSongActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DecsTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListSongScreen()
                }
            }
        }
    }
}

@Composable
fun ListSong() {
    val backgroundclear = painterResource(id = R.drawable.background_player_clear)
    val backgroundcolorlistdark = Color(0xFF27292A)
    val context = LocalContext.current
    val title_actual_list = stringResource(id = R.string.actual_song_list)
    val album_actual = painterResource(id = R.drawable.vinyl)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundcolorlistdark),
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
            .offset(y = 160.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title_actual_list,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = RowdiesFontFamily,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.titleMedium
        )
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .offset(y = 225.dp)
    ) {
        Image(
            painter = album_actual,
            contentDescription = "Album photo",
            modifier = Modifier
                .size(150.dp)
                .clip(shape = RoundedCornerShape(75.dp))
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(180.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = 265.dp)
    ) {
        // Pierwszy przycisk
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp) // tło + border
                .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
                .border(3.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
                .clickable { /* akcja */ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.audiolike),
                contentDescription = "likesong",
                modifier = Modifier.size(48.dp) // mniejsza ikona, odstęp od krawędzi
            )
        }

        // Drugi przycisk
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp)
                .background(colorResource(id = R.color.buttoncolor), shape = CircleShape)
                .border(3.dp, colorResource(id = R.color.buttonborder), shape = CircleShape)
                .clickable {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.backicon),
                contentDescription = "list_podcast",
                modifier = Modifier.size(48.dp)
            )
        }
    }

}

data class Audio(
    val displayName: String?,
    val displayAuthor: String?
)

@Composable
fun AudioInfo(message: Audio) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Black.copy(alpha = 0.2f), RoundedCornerShape(25.dp))
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.audioplay),
                tint = Color.Cyan,
                contentDescription = "playsong",
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.clickable {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        ){
            Text(
                text = message.displayName ?: "Nieznany dźwięk",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Cyan
            )
            Text(
                text = message.displayAuthor ?: "Nieznany autor",
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun AudioList(messages: List<Audio>) {
    LazyColumn(
        modifier = Modifier

            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp)
            .padding(top = 380.dp)
            .padding(bottom = 150.dp)
    ) {
        items(messages) { message ->
            AudioInfo(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListSongScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        ListSong()
        val mockMessages = listOf(
            Audio("Słoneczny Poranek", "Patryk Różański"),
            Audio("Cienie Miasta", "Patryk Różański"),
            Audio("Nocne Marzenia", "Patryk Różański"),
            Audio("Droga bez Końca", "Patryk Różański"),
            Audio("Echo Wspomnień", "Patryk Różański"),
            Audio("Tęsknota w Serduchu", "Patryk Różański"),
            Audio("Złote Liście", "Patryk Różański"),
            Audio("Melodia Przemijania", "Patryk Różański"),
            Audio("Pod Gwiazdami", "Patryk Różański"),
            Audio("Ostatni Taniec", "Patryk Różański")
        )

        AudioList(mockMessages)
    }
}