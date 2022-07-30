package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Assume that this is the same as importing a class in java? The AppCompactActivity() thing?
    //While I knew some C and javascript kinda works for me, this is completely new to me.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onCoinTap()
    }
    private fun onCoinTap() {
        val dice: ImageView = findViewById<ImageView>(R.id.iv_dice)
        dice.setOnClickListener  {
            val randomNumber = (1..6).random()
            rollTheDice(R.drawable.ic_dice, randomNumber.toString())
        }
    }
    //OH; fun stands for function. Makes sense.
    //Weird it's not recognizing iv_dice?
    private fun rollTheDice(imageId: Int, diceSide: String) {
        val dice: ImageView = findViewById<ImageView>(R.id.iv_dice)
        dice.animate().apply {
            duration = 1000
            rotationYBy(1800f)
            dice.isClickable = false
        }.withEndAction {
            dice.setImageResource(imageId)
            Toast.makeText(this, diceSide, Toast.LENGTH_SHORT).show()
            dice.isClickable = true
        }.start()
    }
}