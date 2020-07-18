package com.devomar.products.xogamekotlin

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSelect(view: View)
    {
        val btnChoice = view as ImageView
        var itemID = 0
        when(btnChoice.id)
        {
            R.id.btn1 -> itemID = 1
            R.id.btn2 -> itemID = 2
            R.id.btn3 -> itemID = 3
            R.id.btn4 -> itemID = 4
            R.id.btn5 -> itemID = 5
            R.id.btn6 -> itemID = 6
            R.id.btn7 -> itemID = 7
            R.id.btn8 -> itemID = 8
            R.id.btn9 -> itemID = 9
        }
        Log.d("itemID: ", itemID.toString())
        playXO(itemID, btnChoice)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playXO(itemID:Int, btnChoice:ImageView)
    {
        if (activePlayer == 1)
        {
//            btnChoice.text = "X"
            btnChoice.setImageResource(R.drawable.x_letter_blue)
            player1.add(itemID)
            activePlayer = 2
            autoPlay()
        }else
        {
//            btnChoice.text = "O"
            btnChoice.setImageResource(R.drawable.o_letter_red)
            player2.add(itemID)
            activePlayer = 1
        }

        btnChoice.isEnabled = false
        findWinner()
    }

    fun findWinner()
    {
        var winner = -1
        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        // column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        // column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        // column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        // column 4
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        // column 5
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }

        if (winner != -1)
        {
            if (winner == 1)
            {
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            }
            else if (winner == 2)
            {
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            }
//            else
//            {
//                Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
//            }
        }

    }

    fun autoPlay()
    {
        // check empty items
        val emptyItem = ArrayList<Int>()
        for (itemID in 1..9)
        {
            if (!(player1.contains(itemID) || player2.contains(itemID)))
            {
                emptyItem.add(itemID)
            }
        }

        // select rand index
        val r = Random()
        val randIndex = r.nextInt(emptyItem.size-0)+0
        val itemID = emptyItem[randIndex]
        // interpreter index to button
        var btnSelect:ImageView?
        when(itemID)
        {
            1 -> btnSelect = btn1
            2 -> btnSelect = btn2
            3 -> btnSelect = btn3
            4 -> btnSelect = btn4
            5 -> btnSelect = btn5
            6 -> btnSelect = btn6
            7 -> btnSelect = btn7
            8 -> btnSelect = btn8
            9 -> btnSelect = btn9
            else->{btnSelect = btn1}
        }
        playXO(itemID, btnSelect)

    }

}
