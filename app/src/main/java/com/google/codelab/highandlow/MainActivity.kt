package com.google.codelab.highandlow

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val highBtn = findViewById<Button>(R.id.highBtn)
        val lowBtn = findViewById<Button>(R.id.lowBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        highBtn.setOnClickListener {
            if (gameStart && !answered) {
                highAndLow('h')
            }
        }

        lowBtn.setOnClickListener {
            if (gameStart && !answered) {
                highAndLow('l')
            }
        }

        nextBtn.setOnClickListener {
            if (gameStart) {
                drawCard()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0

        val hitText = findViewById<TextView>(R.id.hitText)
        val loseText = findViewById<TextView>(R.id.loseText)

        hitText.text = getString(R.string.hit_text)
        loseText.text = getString(R.string.lose_text)

        gameStart = true
        drawCard()
    }

    private fun highAndLow(answer: Char) {
        showDroidCard()
        answered = true

        val hitText = findViewById<TextView>(R.id.hitText)
        val loseText = findViewById<TextView>(R.id.loseText)
        val resultText = findViewById<TextView>(R.id.resultText)
        val balance = droidCard - yourCard

        if (balance > 0 && answer == 'h') {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else if (balance < 0 && answer == 'l') {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else {
            loseCount++
            loseText.text = getString(R.string.lose_text) + loseCount
        }
        if (hitCount == 5) {
            resultText.setText(R.string.your_win)
        } else if (loseCount == 5) {
            resultText.setText(R.string.your_lose)
        }
    }

    private fun drawCard() {
        val yourCardImage = findViewById<ImageView>(R.id.yourCardImage)
        val droidCardImage = findViewById<ImageView>(R.id.droidCardImage)

        yourCardImage.setImageResource(R.drawable.z01)
        droidCardImage.setImageResource(R.drawable.z02)

        yourCard = (1..13).random()
        Log.d(tag, "You:$yourCard")
        when (yourCard) {
            1 -> yourCardImage.setImageResource(R.drawable.d01)
            2 -> yourCardImage.setImageResource(R.drawable.d02)
            3 -> yourCardImage.setImageResource(R.drawable.d03)
            4 -> yourCardImage.setImageResource(R.drawable.d04)
            5 -> yourCardImage.setImageResource(R.drawable.d05)
            6 -> yourCardImage.setImageResource(R.drawable.d06)
            7 -> yourCardImage.setImageResource(R.drawable.d07)
            8 -> yourCardImage.setImageResource(R.drawable.d08)
            9 -> yourCardImage.setImageResource(R.drawable.d09)
            10 -> yourCardImage.setImageResource(R.drawable.d10)
            11 -> yourCardImage.setImageResource(R.drawable.d11)
            12 -> yourCardImage.setImageResource(R.drawable.d12)
            13 -> yourCardImage.setImageResource(R.drawable.d13)
        }
        droidCard = (1..13).random()
        Log.d(tag, "droid:$droidCard")
        answered = false
    }

    private fun showDroidCard() {
        val droidCardImage = findViewById<ImageView>(R.id.droidCardImage)
        when (droidCard) {
            1 -> droidCardImage.setImageResource(R.drawable.c01)
            2 -> droidCardImage.setImageResource(R.drawable.c02)
            3 -> droidCardImage.setImageResource(R.drawable.c03)
            4 -> droidCardImage.setImageResource(R.drawable.c04)
            5 -> droidCardImage.setImageResource(R.drawable.c05)
            6 -> droidCardImage.setImageResource(R.drawable.c06)
            7 -> droidCardImage.setImageResource(R.drawable.c07)
            8 -> droidCardImage.setImageResource(R.drawable.c08)
            9 -> droidCardImage.setImageResource(R.drawable.c09)
            10 -> droidCardImage.setImageResource(R.drawable.c10)
            11 -> droidCardImage.setImageResource(R.drawable.c11)
            12 -> droidCardImage.setImageResource(R.drawable.c12)
            13 -> droidCardImage.setImageResource(R.drawable.c13)
        }
    }
}
