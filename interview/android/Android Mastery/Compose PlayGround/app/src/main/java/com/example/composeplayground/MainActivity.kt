package com.example.composeplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.composeplayground.ui.components.MyScaffoldScreen
import com.example.composeplayground.ui.theme.ComposePlayGroundTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlayGroundTheme {
                MyScaffoldScreen(applicationContext)
            }
        }

    }
}