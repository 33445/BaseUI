package com.example.baseui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baseui.ui.theme.*

class LoginPage {
    @Composable
    fun LoginPage(){
        Column(
            Modifier
                .fillMaxSize()
                .background(white)
                .padding(horizontal = 16.dp)
        ) {
            LoginTitle()
            LoginInputBox()
            HintWithUnderline()
            LoginButton()
        }
    }

    private @Composable
    fun LoginTitle() {
        Text(
            text ="Log in with email",
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
            style = h1,
            color = gray,
            textAlign = TextAlign.Center
        )
    }

    private @Composable
    fun LoginInputBox() {
        Column{
           LoginTextFiled("Email address")
            Spacer(modifier = Modifier.height(8.dp))
            LoginTextFiled("Password(8+Characters)")
        }
    }

    private @Composable
    fun LoginTextFiled( placeHolder: String) {
      OutlinedTextField(
          value = "",
          onValueChange ={},
          modifier = Modifier
              .fillMaxWidth()
              .height(56.dp)
              .clip(small),
          placeholder = {
              Text(
                  text ="$placeHolder",
                  style = body1,
                  color= gray
              )
          }
      )
    }

    private @Composable
    fun HintWithUnderline() {
      Column(
          modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
      ) {
          TopText()
          BottomText()

      }
    }

    private @Composable
    fun TopText() {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement=Arrangement.SpaceBetween
       ) {
           var keywordPre="By Clicking below you agree to our".split("")
           var keywordPort = "android consent".split("")
           for(word in keywordPre){
               Text(
                   text=word,
                   style = body2,
                   color = gray
               )
           }
           Text(
               text = "Terms of Use",
               style = body2,
               color = gray,
               textDecoration = TextDecoration.Underline
           )
           for(word in keywordPort){
               Text(
                   text = word,
                   style = body2,
                   color = gray
               )
           }
       }


    }

    private @Composable
    fun BottomText() {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ) {
           Text(
               text = "to Our",
               style = body2,
               color = gray
           )
           Text(
               text = "Privacy Policy",
               style = body2,
               color = gray,
               textDecoration = TextDecoration.Underline
           )
       }
    }



    private @Composable
    fun LoginButton() {
        Button(
            onClick = {  },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .clip(medium),
            colors = ButtonDefaults.buttonColors(backgroundColor = pink900)
        ) {
            Text(
                text="Login in",
                style = button,
                color= white
            )

        }
    }
    @Preview
    @Composable
    fun LoginPageLightPreview(){
        LoginPage()
    }
}