package br.senai.sp.jandira.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp),
                    color = Color(207, 6, 240),
                    shape = RoundedCornerShape(bottomStart = 12.dp)
                ) {}
            }


            Spacer(modifier = Modifier.height(120.dp))


            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240)
                )
                Text(
                    text = stringResource(id = R.string.please_sign_in),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraLight
                )

                Spacer(modifier = Modifier.height(45.dp))

                //FORM
                Column() {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(18.dp),
                        leadingIcon = {Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240)
                        )},
                        label = {
                            Text(
                                text = stringResource(id = R.string.email)
                            )
                        }
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(18.dp),
                        leadingIcon = {Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                            tint = Color(207, 6, 240)
                        )},
                        label = {
                            Text(
                                text = stringResource(id = R.string.password)
                            )
                        }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = { /*TODO*/ }, shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_in),
                                color = Color.White
                            )
                        }

                        Text(text = stringResource(id = R.string.no_account))
                    }
                }
            }

            Surface(
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp),
                color = Color(207, 6, 240),
                shape = RoundedCornerShape(topEnd = 12.dp)
            ) {}
        }
    }
}