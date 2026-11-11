package ro.pub.cs.systems.eim.myapplicationpracticaltest01var06

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.compose.remote.creation.dsl.random

class MainActivity : AppCompatActivity() {

    private lateinit var Hold1: CheckBox
    private lateinit var Hold2: CheckBox
    private lateinit var Hold3: CheckBox
    private lateinit var Play: Button
    private lateinit var editTextNumber: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var editTextNumber3: EditText
    private lateinit var random: Button
    private var listar: List<String> = listOf(
        "1","2","3","*")

    var score = 0
    var scorTotal = 0

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
        editTextNumber = findViewById(R.id.editTextNumber)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        editTextNumber3 = findViewById(R.id.editTextNumber3)
        random = findViewById(R.id.random)
        Hold1.setOnClickListener(ClickListener())
        Hold2.setOnClickListener(ClickListener())
        Hold3.setOnClickListener(ClickListener())
        random.setOnClickListener(ClickListener())
        Play.setOnClickListener{
            val intent = Intent(applicationContext, PracticalTest01Var06SecondaryActivity::class.java)
            intent.putExtra("score", score.toString())
            startActivityForResult(intent, 1)
        }
    }
    private inner class ClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            when (v.id) {
                R.id.Play -> {

                }
                R.id.random -> {
                    if(!Hold1.isChecked) {
                        editTextNumber.setText(listar.random())
                    }
                    if(!Hold2.isChecked) {
                        editTextNumber2.setText(listar.random())
                    }
                    if(!Hold3.isChecked) {
                        editTextNumber3.setText(listar.random())

                    }
                }
            }
            if (Hold1.isChecked || Hold2.isChecked || Hold3.isChecked) {
                if (editTextNumber.text.toString() == editTextNumber2.text.toString()
                    || editTextNumber2.text.toString() == editTextNumber3.text.toString()
                    || editTextNumber.text.toString() == editTextNumber3.text.toString())
                {
                    score = 50
                }
            }
            if (!Hold1.isChecked && !Hold2.isChecked && !Hold3.isChecked){
                if (editTextNumber.text.toString() == editTextNumber2.text.toString()
                    && editTextNumber2.text.toString() == editTextNumber3.text.toString()) {
                    score = 100
                }
            }
            if (Hold1.isChecked && Hold2.isChecked && Hold3.isChecked){
                score = 0
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        android.widget.Toast.makeText(this, editTextNumber3.toString(),android.widget.Toast.LENGTH_SHORT).show()
    }
}