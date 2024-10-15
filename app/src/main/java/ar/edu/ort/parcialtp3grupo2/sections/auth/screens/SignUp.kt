package ar.edu.ort.parcialtp3grupo2.sections.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.AlertDialog
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.GenericTextField
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.PasswordTextField
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.ValidatedTextField
import ar.edu.ort.parcialtp3grupo2.sections.auth.data.RetrofitServiceFactory
import ar.edu.ort.parcialtp3grupo2.sections.auth.data.User
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthDestination
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton

@Composable
fun SignUp(
    innerPadding: PaddingValues,
    globalController:NavHostController,
    authController:NavHostController
) {
    val scrollState = rememberScrollState()
    var (email, setEmail) = remember { mutableStateOf("") }
    var validMail = email.contains("@gmail.com")
    var (username, setUsername) = remember { mutableStateOf("") }
    var (password, setPassword) =  remember { mutableStateOf("") }
    val shouldShowDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if(!isSystemInDarkTheme()) {
            Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = "login background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = painterResource(id = R.drawable.colored_carrot),
                contentDescription = "carrot",
                modifier = Modifier.padding(56.dp)
            )

            Text(text = "Sign Up",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold)


            Text(text = "Enter your credentials to continue",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                fontSize = 16.sp,
                color = Color(0xFF7C7C7C),)

            Spacer(modifier = Modifier.height(30.dp))

            GenericTextField(text = "Username", value = username, setValue = setUsername)

            Spacer(modifier = Modifier.height(36.dp))

            ValidatedTextField(text = "Email", value = email, setValue = setEmail, isValid = validMail)

            Spacer(modifier = Modifier.height(36.dp))

            PasswordTextField(value = password, setValue = setPassword)

            Spacer(modifier = Modifier.height(16.dp))

            Row (
                Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp)) {

                Text(text = "By continuing you agree to our ",
                    color = Color(0xFF7C7C7C),
                    fontSize = 12.sp,
                )

                Text(text = "Terms of Service", modifier = Modifier.clickable {  },
                    color = Color(0xFF53B175),
                    fontSize = 12.sp,

                    )

            }

            Row (
                Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp)) {

                Text(text = "and ",
                    color = Color(0xFF7C7C7C),
                    fontSize = 12.sp,
                )

                Text(text = "Privacy Policy.",
                    modifier = Modifier
                        .clickable { },
                    color = Color(0xFF53B175),
                    fontSize = 12.sp,)
            }

            if (shouldShowDialog.value) {
                AlertDialog(shouldShowDialog = shouldShowDialog, topText = "Wrong Email Address", message = "The Email Must Be a Google Domain: example@gmail.com")
            }



            GreenButton(onClick = {
                if (validMail){
                    authController.navigate(AuthDestination.Login.route)
                } else {
                    shouldShowDialog.value = true
                }

            }, text = "Sign Up")

            Row {
                Text(text = "Already have an account? ",
                    fontWeight = FontWeight.Bold)

                Text(text = "Sign in",
                    modifier = Modifier.clickable {
                        authController.navigate(AuthDestination.Login.route)                    },
                    color = Color(0xFF53B175))

            }

            Spacer(modifier = Modifier.height(36.dp))

        }
    }
}
