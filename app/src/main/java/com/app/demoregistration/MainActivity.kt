package com.app.demoregistration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    lateinit var et_name:EditText
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var rg_gender:RadioGroup
    lateinit var chk_agree:CheckBox
    lateinit var btn_submit:Button
    private val sharedPrefFile = "kotlinsharedpreference"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_name=findViewById(R.id.et_name)
        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_password)
        rg_gender=findViewById(R.id.rg_gender)
        chk_agree=findViewById(R.id.chk_agree)
        btn_submit=findViewById(R.id.btn_submit)

        btn_submit.setOnClickListener({
            val name=et_name.text.toString().trim()
            val email=et_email.text.toString().trim()
//            val radioGroup = findViewById<RadioGroup>(R.id.rg_gender)
//            radioGroup?.setOnCheckedChangeListener { group, checkedId ->
//               var  text = "You selected: "
//                text += if (R.id.radio_male == checkedId) "male" else "female"
//            }
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)

            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            val intent= Intent(this, ShowActivity::class.java)
            editor.putString("name",name)
            editor.putString("email",email)
            editor.apply()
            editor.commit()
            startActivity(intent)


        })

    }


}