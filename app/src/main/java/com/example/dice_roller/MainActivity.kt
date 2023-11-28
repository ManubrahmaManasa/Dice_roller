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

        val diceDrawableResource =  when(diceroll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceDrawableResource)
        rollText.setText("Dice rolled : "+diceroll.toString())


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