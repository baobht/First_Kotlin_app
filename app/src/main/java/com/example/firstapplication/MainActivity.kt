package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    fun sum(a:Int,b:Int):Int = a+b

    fun showToast(a:Int,b:Int):Unit{
        Toast.makeText(this,"$a and $b",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSum.setOnClickListener{
            Snackbar.make(it, ""+sum(edit1.text.toString().toInt(),edit2.text.toString().toInt()), Snackbar.LENGTH_LONG)
                    .setAction("Action") {
                        // Responds to click on the action
                    }
                    .show()
        }
    }
}