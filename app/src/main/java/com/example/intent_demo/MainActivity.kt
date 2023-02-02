package com.example.intent_demo

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intent = Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH).apply {
                putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE)
                putExtra(MediaStore.EXTRA_MEDIA_TITLE, binding.TextField.text)
                putExtra(SearchManager.QUERY, binding.TextField.text)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else{
            Toast.makeText(this@MainActivity,"Required App is not installed",Toast.LENGTH_SHORT).show()
        }
        }
    }


}