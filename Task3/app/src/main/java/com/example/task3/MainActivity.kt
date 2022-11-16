package com.example.task3

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var flag = false
    var mediaPlayer : MediaPlayer? = null
    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tts = TextToSpeech(this , TextToSpeech.OnInitListener {
            flag = true
        })





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {


        R.id.on -> {
            val audioURL = " https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3"
            mediaPlayer = MediaPlayer()
            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

            try{
                mediaPlayer!!.setDataSource(audioURL)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()
            }catch (e : IOException){
                e.printStackTrace()
            }

            Toast.makeText(this , "Audio started playing" , Toast.LENGTH_LONG).show()

            true
        }

        R.id.off -> {

            if(mediaPlayer!!.isPlaying) {
                mediaPlayer!!.stop()
                mediaPlayer!!.reset()
                mediaPlayer!!.release()
            }

            else{
                Toast.makeText(this , "Audio paused" , Toast.LENGTH_LONG).show()
            }
            true
        }

        R.id.speak -> {
            val txt1 : TextView = findViewById(R.id.textView)
            val txt2 = txt1!!.text.toString()
            tts!!.speak(txt2 , TextToSpeech.QUEUE_FLUSH , null , "")
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}