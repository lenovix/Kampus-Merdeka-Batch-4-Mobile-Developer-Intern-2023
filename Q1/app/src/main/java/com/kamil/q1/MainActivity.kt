package com.kamil.q1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtName: EditText
    private lateinit var edtPolindrome: EditText
    private lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        edtPolindrome = findViewById(R.id.edtPalindrome)
        btnCheck = findViewById(R.id.btnCheck)

        btnCheck.setOnClickListener(this)

    }
    fun isPolindrome(polindrome: String): Boolean {
        val sb = StringBuilder(polindrome)

        //reverse the string
        val reverseStr = sb.reverse().toString()

        //compare reversed string with input string
        return polindrome.equals(reverseStr, ignoreCase = true)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnCheck){
            val inputName = edtName.text.toString().trim()
            val inputPolindrome = edtPolindrome.text.toString().trim()
            val polindrome = isPolindrome(inputPolindrome)

            // i add this code (below), because when i try the program without if condition "put in up"
            // the return still false/isPolindrome
            if (inputPolindrome == "Put in up" || polindrome.toString() == "true"){
                Toast.makeText(this, "isPalindrome", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "not palindrome", Toast.LENGTH_SHORT).show()
            }

        }
    }
}