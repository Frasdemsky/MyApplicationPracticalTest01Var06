package ro.pub.cs.systems.eim.myapplicationpracticaltest01var06

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {

    private lateinit var OK: Button
    private lateinit var editTextNumber4: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        OK = findViewById(R.id.OK)
        editTextNumber4 = findViewById(R.id.editTextNumber4)
        OK.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("total", editTextNumber4.text.toString().toInt())
            startActivity(intent)
        }
        editTextNumber4.setText(intent.getStringExtra("score"))

    }
    private inner class ClickListener : View.OnClickListener{
        override fun onClick(v: View) {
            when (v.id) {
                R.id.OK -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}