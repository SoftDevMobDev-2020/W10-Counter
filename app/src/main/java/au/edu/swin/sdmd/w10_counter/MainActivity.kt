package au.edu.swin.sdmd.w10_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    private val tapsViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val label = findViewById<TextView>(R.id.counter)
        val button = findViewById<Button>(R.id.count)

        label.text = tapsViewModel.tapCount.toString()

        button.setOnClickListener {
            tapsViewModel.updateTaps()
            label.text = tapsViewModel.tapCount.toString()
        }

    }
}

class CounterViewModel: ViewModel() {
    var tapCount = 0

    fun updateTaps() {
        ++tapCount
    }

}