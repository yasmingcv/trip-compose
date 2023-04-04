package br.senai.sp.jandira.login

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.components.BottomShape
import br.senai.sp.jandira.login.components.TopShape
import br.senai.sp.jandira.login.ui.theme.LoginTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TopShape()
            }

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240)
                )
                Text(
                    text = stringResource(id = R.string.create_new_account),
                    fontSize = 14.sp,
                    color = Color(160, 156, 156)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .size(100.dp)

                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopEnd),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.dp,
                            Brush.horizontalGradient(
                                listOf(Color.Magenta, Color.White)
                            )
                        )
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )

                    }
                    Image(
                        painter = painterResource(id = R.drawable.camera_plus),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(x = 0.dp, y = 0.dp)
                            .size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                //FORM
                Column() {

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_person_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.username)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_phone_android_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.phone)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_email_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.email)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_lock_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.password)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(21.dp))

                    Row() {
                        Checkbox(checked = false, onCheckedChange = {})
                        Text(
                            text = stringResource(id = R.string.over_18),
                            modifier = Modifier.padding(top = 15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(21.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = { /*TODO*/ }, shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Row() {
                                Text(
                                    text = stringResource(id = R.string.create_account).uppercase(),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row() {
                            Text(
                                text = stringResource(id = R.string.have_account),
                                fontSize = 12.sp,
                                color = Color(160, 156, 156)
                            )

                            Spacer(modifier = Modifier.width(2.dp))

                            Text(
                                text = stringResource(id = R.string.sign_in),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(207, 6, 240),
                            )
                        }
                    }


                }
            }

            BottomShape()

        }
    }
}
