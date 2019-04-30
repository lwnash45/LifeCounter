package edu.washington.lwnash45.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.player.view.*
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loser: TextView = findViewById(R.id.loser)

        fun checkLoser(health: Int, playerID: Int) {
            if (health <= 0) {
                loser.text = "Player $playerID Loses!!"
            }
        }



        var playerOne: ConstraintLayout = findViewById(R.id.playerOne)
        var playerTwo: ConstraintLayout = findViewById(R.id.playerTwo)
        var playerThree: ConstraintLayout = findViewById(R.id.playerThree)
        var playerFour: ConstraintLayout = findViewById(R.id.playerFour)
        var playerArr = arrayListOf(playerOne, playerTwo, playerThree, playerFour)
        var colorArr = arrayListOf(R.color.red, R.color.green, R.color.blue, R.color.yellow)




        for ((index, playerLayout) in playerArr.withIndex()) {
            var player = playerLayout.playerLayout
            player.setBackgroundResource(colorArr[index])
            var playerNum = index + 1

            player.playerText.playerName.text = "Player $playerNum"
            player.playerText.playerHealth.text = "Health: 30"
            player.addButtons.add.setOnClickListener {
                var health = player.playerText.playerHealth.text.toString().substring(8).toInt() + 1
                player.playerText.playerHealth.text = "Health: $health"
            }
            player.addButtons.addFive.setOnClickListener {
                var health = player.playerText.playerHealth.text.toString().substring(8).toInt() + 5
                player.playerText.playerHealth.text = "Health: $health"
            }
            player.minusButtons.minus.setOnClickListener {
                var health = player.playerText.playerHealth.text.toString().substring(8).toInt() - 1
                player.playerText.playerHealth.text = "Health: $health"
                checkLoser(health, playerNum)
            }
            player.minusButtons.minusFive.setOnClickListener {
                var health = player.playerText.playerHealth.text.toString().substring(8).toInt() - 5
                player.playerText.playerHealth.text = "Health: $health"
                checkLoser(health, playerNum)
            }
        }
    }
}
