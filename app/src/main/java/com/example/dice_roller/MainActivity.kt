package com.example.dice_roller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceroll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val rollText: TextView = findViewById(R.id.Textview)
        val luckynumber = 4
        val str: String

        val diceDrawableResource =  when(diceroll){
            1 -> {
                str = "So sorry! You rolled a 1. Try again!"
                R.drawable.dice_1
            }
            2 -> {
                str = "Sadly, you rolled a 2. Try again!"
                R.drawable.dice_2
            }
            3 -> {
                str = "Unfortunately, you rolled a 3. Try again!"
                R.drawable.dice_3
            }
            luckynumber -> {
                str = "You Win!!!!!!!"
                R.drawable.dice_4
            }
            5 -> {
                str = "Don't cry! You rolled a 5. Try again!"
                R.drawable.dice_5
            }
            else -> {
                str = "Apologies! You rolled a 6. Try again!"
                R.drawable.dice_6
            }
        }

        diceImage.setImageResource(diceDrawableResource)

        rollText.text = str



        diceImage.contentDescription = diceroll.toString()
    }
}

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}