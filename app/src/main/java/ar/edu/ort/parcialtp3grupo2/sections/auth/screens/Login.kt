package ar.edu.ort.parcialtp3grupo2.sections.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.GenericTextField
import ar.edu.ort.parcialtp3grupo2.sections.auth.components.PasswordTextField
import ar.edu.ort.parcialtp3grupo2.sections.auth.navigation.AuthDestination
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButton

@Composable
fun Login(
    innerPadding: PaddingValues,
    authNavhostController: NavHostController,
    globalNavhostController: NavHostController
) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "login background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(painter = painterResource(id = R.drawable.colored_carrot),
                contentDescription = "carrot",
                modifier = Modifier.padding(56.dp)
            )

            Text(text = "Loging",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold)


            Text(text = "Enter your emails and password",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                fontSize = 16.sp,
                color = Color(0xFF7C7C7C),)

            Spacer(modifier = Modifier.height(30.dp))

            GenericTextField(text = "Email")

            Spacer(modifier = Modifier.height(36.dp))

            PasswordTextField()

            Text(text = "Forgot Password?",
                modifier = Modifier
                    .align(alignment = Alignment.End)
                    .padding(16.dp))


            GreenButton(onClick = {
                 authNavhostController.navigate(AuthDestination.Location.route)            }, text = "Log In")

            Row {
                Text(text = "Don’t have an account? ",
                    fontWeight = FontWeight.Bold)

                Text(text = "Singup",
                    modifier = Modifier.clickable {
                         authNavhostController.navigate(AuthDestination.Register.route)                    },
                    color = Color(0xFF53B175))
            }

        }
    }
}
