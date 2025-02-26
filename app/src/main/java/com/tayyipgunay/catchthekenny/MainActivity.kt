package com.tayyipgunay.catchthekenny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tayyipgunay.catchthekenny.databinding.ActivityMainBinding
import java.util.LinkedList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // View Binding sayesinde layout'taki view'lere tip güvenli erişim sağlanır.
    private lateinit var binding: ActivityMainBinding

    // XML'deki 9 ImageView referansını tutan liste.
    // Bu liste, her 500ms'de rastgele bir görselin gösterilmesi için kullanılır.
    private val imageList = LinkedList<ImageView>()

    // Kullanıcının kazanmış olduğu skorun tutulduğu değişken.
    private var score = 0

    // Belirli aralıklarla çalıştırılacak kod bloğunu barındıran Runnable.
    // Bu Runnable, her 500ms'de rastgele bir ImageView'i görünür yapar.
    private var runnable = Runnable {}

    // Ana iş parçacığında (UI thread) zamanlanmış görevleri çalıştırmak için Handler.
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Layout binding ile XML dosyası şişirilir ve setContentView(binding.root) ile ekrana yansıtılır.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 'with(binding)' bloğu, binding üzerinden view'lere erişimi kısaltır.
        with(binding) {
            // XML layout dosyasındaki 9 ImageView'i imageList'e ekliyoruz.
            imageList.add(imageView1)
            imageList.add(imageView2)
            imageList.add(imageView3)
            imageList.add(imageView4)
            imageList.add(imageView5)
            imageList.add(imageView6)
            imageList.add(imageView7)
            imageList.add(imageView8)
            imageList.add(imageView9)

            // Her bir ImageView'e tıklama dinleyicisi ekleyerek doğru zamanda tıklama yapılırsa skoru artırıyoruz.
            imageList.forEach { image ->
                image.setOnClickListener {
                    increaseScore() // Tıklama gerçekleştiğinde skor artışı.
                }
            }

            // Yeniden başlat butonuna tıklanması durumunda oyunun resetlenip yeniden başlatılmasını sağlıyoruz.
            button.setOnClickListener {
                restartGame()
            }
        }

        // Oyunun başlangıcında görselleri rastgele göster/gizle mekanizmasını ve geri sayım timer'ını başlatıyoruz.
        hideImage()
        startTimer()
    }

    /**
     * 15.5 saniyelik geri sayım başlatılır.
     * Her saniye kalan süre güncellenir; süre dolduğunda tüm ImageView'ler gizlenir
     * ve kullanıcıya final skor Toast mesajı ile gösterilir.
     */
    private fun startTimer() {
        object : CountDownTimer(15500, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Kalan süreyi saniye cinsinden TextView'e yazar.
                binding.textView.text = "Time: ${millisUntilFinished / 1000}"
            }
            override fun onFinish() {
                // Timer bitiminde, scheduled runnable iptal edilir.
                handler.removeCallbacks(runnable)
                // Oyun bittiğinde tüm görseller gizlenir.
                imageList.forEach { it.visibility = View.INVISIBLE }
                // Final skor kullanıcıya Toast ile bildirilir.
                Toast.makeText(this@MainActivity, "Score: $score", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    /**
     * hideImage fonksiyonu, her 500ms'de çalışarak:
     * - Tüm ImageView'leri gizler.
     * - Rastgele seçilen bir ImageView'i görünür yapar.
     * Bu döngü, oyun süresince devam eder.
     */
    private fun hideImage() {
        runnable = object : Runnable {
            override fun run() {
                // Önce tüm ImageView'ler gizlenir.
                imageList.forEach { it.visibility = View.INVISIBLE }
                // 0 ile imageList boyutu arasından rastgele bir index seçilir.
                val randomIndex = Random.nextInt(imageList.size)
                // Seçilen ImageView görünür hale getirilir.
                imageList[randomIndex].visibility = View.VISIBLE
                // Bu runnable, 500ms sonra tekrar çalıştırılır.
                handler.postDelayed(this, 500)
            }
        }
        // İlk runnable çağrısı yapılarak döngü başlatılır.
        handler.post(runnable)
    }

    /**
     * increaseScore fonksiyonu:
     * - Kullanıcı ImageView'e tıkladığında çağrılır.
     * - Skoru 1 artırır ve güncel skoru TextView üzerinde gösterir.
     */
    private fun increaseScore() {
        score++
        binding.textView2.text = "Score: $score"
    }

    /**
     * restartGame fonksiyonu:
     * - Oyunu sıfırlamak için skoru ve zaman TextView'lerini resetler.
     * - Yeni bir geri sayım ve görsel gösterme döngüsü başlatır.
     */
    private fun restartGame() {
        score = 0
        binding.textView2.text = "Score: $score"
        binding.textView.text = "Time: 0"
        // Oyunun yeniden başlaması için timer ve görsel döngüsü yeniden başlatılır.
        startTimer()
        hideImage()
    }
}
