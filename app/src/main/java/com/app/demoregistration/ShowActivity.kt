package com.app.demoregistration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowActivity:AppCompatActivity() {
    lateinit var tv_name:TextView
    lateinit var tv_email:TextView
    lateinit var tv_gender:TextView
    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        tv_name=findViewById(R.id.tv_name)
        tv_email=findViewById(R.id.tv_email)
        tv_gender=findViewById(R.id.tv_gender)
       // val name=intent.getStringExtra("name")
      //  val email=intent.getStringExtra("email")
       // val gender=intent.getStringExtra("gender")
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name","")
        val email = sharedPreferences.getString("email","defaultname")


        tv_name.setText(name)
        tv_email.setText(email)
       // tv_gender.setText(gender)
    }
}