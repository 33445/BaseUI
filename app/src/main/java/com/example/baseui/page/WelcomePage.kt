package com.example.baseui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baseui.R
import com.example.baseui.ui.theme.*

class WelcomePage {
    @Composable
    fun WelcomePage(){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(pink100)
        ){
            Image(
                 painter = rememberVectorPainter(image =
                            ImageVector.vectorResource(id = R.drawable.ic_light_welcome_bg)),
                 contentDescription ="welcome_bg",
                 modifier = Modifier.fillMaxSize()
            )
            WelcomeContent()
        }
    }

    private @Composable
    fun WelcomeContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(72.dp))
            LeafImage()
            Spacer(modifier = Modifier.height(48.dp))
            WelcomeTitle()
            Spacer(modifier = Modifier.height(40.dp))
            WelcomeButtons()

        }
    }
    private @Composable
    fun LeafImage() {
        Image(
            painter = rememberVectorPainter(
                image = ImageVector.vectorResource(
                    id = R.drawable.ic_light_welcome_illos
                )),
            contentDescription ="weclome_iilos",
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 88.dp)
        )
    }
    private @Composable
    fun WelcomeTitle() {
//        TODO("Not yet implemented")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberVectorPainter(
                    image = ImageVector.vectorResource(
                        id = R.drawable.ic_light_logo
                    )),
                contentDescription = "weclome_logo",
                 modifier = Modifier
                     .wrapContentSize()
                     .height(32.dp)
                 )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .wrapContentSize(align = Alignment.BottomCenter)
            ){
                Text(
                    text = "Beautiful home garden solutions",
                    textAlign = TextAlign.Center,
                    style =subtitle1,
                    color= gray)
            }
        }
    }



    private @Composable
    fun WelcomeButtons() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .clip(medium),
                colors = ButtonDefaults.buttonColors(backgroundColor = pink900)
            ) {
                Text(
                    text="Create account",
                    style = button,
                    color= white
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(
                onClick = {}
            ) {
                Text(
                    text = "Log in",
                    style = button,
                    color = pink900
                )
            }

        }
    }


   @Preview
   @Composable
   fun WelcomePageLightPreview(){
       WelcomePage()
   }
}

