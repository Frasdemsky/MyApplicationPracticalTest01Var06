package ro.pub.cs.systems.eim.myapplicationpracticaltest01var06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
class MainActivity : AppCompatActivity() {

    private lateinit var Hold1: CheckBox
    private lateinit var Hold2: CheckBox
    private lateinit var Hold3: CheckBox
    private lateinit var Play: Button
    private lateinit var editTextNumber: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var editTextNumber3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Hold1 = findViewById(R.id.Hold1)
        Hold2 = findViewById(R.id.Hold2)
        Hold3 = findViewById(R.id.Hold3)
        Play = findViewById(R.id.Play)
    }

}