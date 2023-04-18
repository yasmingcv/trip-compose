package br.senai.sp.jandira.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.PanoramaFishEye
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login.components.BottomShape
import br.senai.sp.jandira.login.components.TopShape
import br.senai.sp.jandira.login.repository.UserRepository
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

    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }

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

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(207, 6, 240)
                )
                Text(
                    text = stringResource(id = R.string.please_sign_in),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(160, 156, 156)
                )

                Spacer(modifier = Modifier.height(45.dp))

                //FORM
                Column() {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = emailState,
                        onValueChange = { emailState = it },
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
                        value = passwordState,
                        onValueChange = { passwordState = it },
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_lock_24),
                                contentDescription = null,
                                tint = Color(207, 6, 240)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibilityState = !passwordVisibilityState
                            }) {
                                Icon(
                                    imageVector =
                                        if(passwordVisibilityState)
                                            Icons.Default.VisibilityOff
                                        else
                                            Icons.Default.Visibility,
                                    contentDescription = ""
                                )
                            }
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.password)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = {
                                authenticate(emailState, passwordState, context)
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                        ) {
                            Row() {
                                Text(
                                    text = stringResource(id = R.string.sign_in).uppercase(),
                                    color = Color.White
                                )
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.baseline_arrow_forward_24
                                    ),
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(32.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.no_account),
                                fontSize = 12.sp,
                                color = Color(160, 156, 156)
                            )

                            Spacer(modifier = Modifier.width(2.dp))

                            TextButton(
                                onClick = {
                                    var openSignUp = Intent(context, SignUpActivity::class.java)
                                    context.startActivity(openSignUp)
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.sign_up),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(207, 6, 240),
                                )
                            }
                        }
                    }
                }
            }

            BottomShape()

        }
    }
}

fun authenticate(
    email: String,
    password: String,
    context: Context
) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(
        email,
        password
    )

    if (user != null) {
        val openHome = Intent(context, HomeActivity::class.java)
        context.startActivity(openHome)
    }

}
