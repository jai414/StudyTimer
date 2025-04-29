package com.example.studytimer

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import android.widget.Chronometer
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private var pauseOffset: Long = 0L
    private var running: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Ensure this points to your XML layout

        chronometer = findViewById(R.id.chronometer)
        val btnStart = findViewById<Button>(R.id.button_start)
        val btnStop = findViewById<Button>(R.id.button_stop)
        val btnReset = findViewById<Button>(R.id.button_reset)

        btnStart.setOnClickListener { startStopwatch() }
        btnStop.setOnClickListener { stopStopwatch() }
        btnReset.setOnClickListener { resetStopwatch() }
    }

    private fun startStopwatch() {
        if (!running) {
            // resume from where we left off
            chronometer.base = SystemClock.elapsedRealtime() - pauseOffset
            chronometer.start()
            running = true
        }
    }

    private fun stopStopwatch() {
        if (running) {
            chronometer.stop()
            // save the elapsed time
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
            running = false
        }
    }

    private fun resetStopwatch() {
        // reset to zero
        chronometer.base = SystemClock.elapsedRealtime()
        pauseOffset = 0L
    }
}
