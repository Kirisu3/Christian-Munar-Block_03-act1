package com.munar.christian.block3.p1.quiz

import android.animation.Animator.AnimatorPauseListener
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var timeselected: Int = 0
    private var timeCountDown: CountDownTimer? = null
    private var timeProgress = 0
    private var pauseOffSet: Long = 0
    private var isStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn: ImageButton = findViewById(R.id.btnAdd)
        addBtn.setOnClickListener{
           setTimeFunction()
        }
    }

    private fun startTimer(pauseOfSetL: Long)
    {
        val progressBar = findViewById<ProgressBar>(R.id.pbTimer)
        progressBar.progress = timeProgress
        timeCountDown = object :CountDownTimer(
            (timeselected*1000).toLong() - pauseOfSetL*1000, 1000)
        {
            override fun onTick(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }
    }
    private fun setTimeFunction()
    {
        val timeDialog = Dialog(this)
        timeDialog.setContentView(R.layout.add_dialog)
        val timeSet = timeDialog.findViewById<EditText>(R.id.etGetTime)
        val timeLeftTv: TextView = findViewById(R.id.tvTimeLeft)
        val btnStart: Button = findViewById(R.id.btnPlayPause)
        val progressBar = findViewById<ProgressBar>(R.id.pbTimer)
        timeDialog.findViewById<Button>(R.id.btnOk).setOnClickListener {
            if (timeSet.text.isEmpty())
            {
                Toast.makeText(this, "Enter time Duration", Toast.LENGTH_SHORT).show()
            }
            else
            {
                timeLeftTv.text = timeSet.text
                btnStart.text = "Start"
                timeselected = timeSet.text.toString().toInt()
                progressBar.max = timeselected
            }
            timeDialog.show()
        }

    }
}