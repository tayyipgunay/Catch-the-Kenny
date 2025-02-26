package com.tayyipgunay.catchthekenny

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.LinkedList
import kotlin.properties.Delegates
import kotlin.random.Random

private lateinit var image1: ImageView
private lateinit var image2: ImageView
private lateinit var image3: ImageView
private lateinit var image4: ImageView
private lateinit var image5: ImageView
private lateinit var image6: ImageView
private lateinit var image7: ImageView
private lateinit var image8: ImageView
private lateinit var image9: ImageView
private lateinit var timeText: TextView
private lateinit var scoreText: TextView
private lateinit var Restart: Button


//var imagearray:ArrayList<ImageView>()
// var imagearray=ArrayList<ImageView> ()
//var imagearray = ArrayList<ImageView>()


class MainActivity : AppCompatActivity() {
    var runnable = Runnable {}//runnable bir arayüzdür.
    var handler = Handler(Looper.getMainLooper())
    private var score: Int = 0

    //var imagearray = ArrayList<ImageView>()
    var imagearray = LinkedList<ImageView>()///array listte olabilir.

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.textView)
        scoreText = findViewById(R.id.textView2)
        Restart = findViewById(R.id.button)
        image1 = findViewById(R.id.imageView1)
        image2 = findViewById(R.id.imageView2)
        image3 = findViewById(R.id.imageView3)
        image4 = findViewById(R.id.imageView4)
        image5 = findViewById(R.id.imageView5)
        image6 = findViewById(R.id.imageView6)
        image7 = findViewById(R.id.imageView7)
        image8 = findViewById(R.id.imageView8)
        image9 = findViewById(R.id.imageView9)
        imagearray.add(image1)//binding.image1View olarak da yazabilirz.
        imagearray.add(image2)
        imagearray.add(image3)
        imagearray.add(image4)
        imagearray.add(image5)
        imagearray.add(image6)
        imagearray.add(image7)
        imagearray.add(image8)
        imagearray.add(image9)

        HideImage()
        Zamanlama()

    }

    fun Zamanlama() {

        object : CountDownTimer(15500, 1000) {
            override fun onTick(a: Long) {
                timeText.text = "Time:" + a / 1000

            }

            override fun onFinish() {

                handler.removeCallbacks(runnable)
                for (image in imagearray) {
                    image.visibility = View.INVISIBLE
                }


                Toast.makeText(this@MainActivity, "skorunuz $score", Toast.LENGTH_SHORT).show()
            }


        }


            .start()
    }


    fun HideImage() {

        // Toast.makeText(this@MainActivity, "HideImage Çalışıyor.", Toast.LENGTH_LONG).show()
val random=Random
        runnable = object : Runnable {

            override fun run() {
                for (image in imagearray) {
                    image.visibility = View.INVISIBLE
                }


                val randomIndex = random.nextInt(9)
                imagearray[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable, 500)
            }
        }
        handler.post(runnable)

    }


    fun increasScore(view: View) {
        score = score + 1
        scoreText.text = "Score:$score"
    }

    fun Restart(view: View) {

        // val intent = Intent(this@MainActivity, MainActivity::class.java)
        //finish()
        //startActivity(intent)
        score = 0
        scoreText.text = "Score:$score"
        timeText.text = "Time:0"
        Zamanlama()//zamanı başlatır ve bittiğinde ne olacağını olur.on finishe  remove runnable ile  kapatıyoruz.

        HideImage()//nesneleri random olarak saklar. runnable ile yapar.


    }
}





