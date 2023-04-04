package br.senai.sp.jandira.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.paris), contentDescription = "")

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(19.dp)
                        , verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.susanna_profile),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(48.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = stringResource(id = R.string.name),
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Column() {
                            Row() {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_place_24),
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier.padding(top = 3.dp, end = 3.dp)
                                )

                                Text(
                                    text = stringResource(id = R.string.you_are_in),
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }

                            Text(
                                text = stringResource(id = R.string.my_trips),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp
                            )
                        }
                    }
                }
            }

        Column() {
            Text(text = stringResource(id = R.string.categories))

            //parei aqui :)
            LazyRow(){
                //items()
            }
        }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LoginTheme {
        HomeScreen()
    }
}