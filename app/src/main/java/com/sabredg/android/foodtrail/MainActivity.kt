package com.sabredg.android.foodtrail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sabredg.android.foodtrail.model.Chosen
import com.sabredg.android.foodtrail.ui.ChoicesPage
import com.sabredg.android.foodtrail.ui.theme.FoodTrailTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var chosen by rememberSaveable { mutableStateOf(Chosen()) }

            FoodTrailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ChoicesPage(chosen = chosen)
                }
            }
        }
    }
}