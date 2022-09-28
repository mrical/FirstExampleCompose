package com.example.firstexamplecompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstexamplecompose.ui.theme.FirstExampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstExampleComposeTheme{

                MyLoginScreen()
            }
        }
    }
    @Composable

    fun MyLoginScreen(){
        var username= remember {
            mutableStateOf("")
        }
        var password= remember{
            mutableStateOf("")
        }
        fun validateLogin(username:String,password:String):Boolean{
            if(username == "ABCD" && password == "123456"){
                return true
            }
            return false
        }

        Box(modifier=Modifier.background(Color.Yellow)){
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(20.dp),verticalArrangement=Arrangement.Center){
                Text(text="Enter your credentials")
                Spacer(modifier=Modifier.height(20.dp))
                OutlinedTextField(value = username.value, onValueChange= { username.value = it },label={ Text(text="User name") },modifier= Modifier.fillMaxWidth(), placeholder = {Text(text="Enter user name")})
                OutlinedTextField(value = password.value, onValueChange = {password.value=it},label={Text(text="Password")},modifier=Modifier.fillMaxWidth(), placeholder = {Text(text="Enter password")})
                Button(onClick = {
                    if(validateLogin(username.value.toString(),password.value.toString())){
                        Toast.makeText(this@MainActivity,"Correct Credentials",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@MainActivity,"In Correct Credentials",Toast.LENGTH_LONG).show()
                    }
                }, modifier = Modifier.fillMaxWidth()){
                    Text(text="Login")
                }
            }
        }

    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FirstExampleComposeTheme {
            MyLoginScreen()
        }
    }
}



