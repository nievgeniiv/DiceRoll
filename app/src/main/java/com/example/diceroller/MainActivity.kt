package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView   //lateinit (отложеная инициализация) - говорит, что данная переменная будет определена позже. Сейчас ее моджно установть только null,
    //но необходимо будет установть проверки на null, что усложнит код. Устанавливать значение отличное от null можно после setContentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button) // Поиск элемента по id. Еще раз посмотреть, что такое R
        rollButton.text = "Let's Roll"

        //Нажатие на кнопку с id roll_button
        rollButton.setOnClickListener {
            //Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show(); //Всплывающее сообщение
            //Toast.LENGTH_SHORT - время, на которое показывается сообщение
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image) //инициализация переменной
    }

    private fun rollDice() {
        var randomInt = Random().nextInt(6) + 1
        //val diceImage: ImageView = findViewById(R.id.dice_image)
        //resultText.text = randomInt.toString()  //toString() - преобразует формат в String
        val drawerResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawerResource) // Установка изобрадения
    }

}
