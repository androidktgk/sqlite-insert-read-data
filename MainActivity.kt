package com.govind8061.simplesimple

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper=MyHelper(this)
        val database=helper.readableDatabase


        val cursor=database.rawQuery("SELECT name,price FROM Products", arrayOf())

        if (cursor!=null){
            cursor.moveToFirst()
        }
        val builderString=StringBuilder()

        do {
            val name=cursor.getString(0)
            val price= cursor.getDouble(1)
            builderString.append("NAME: "+name+"\nPRICE :"+price)
        }while (cursor.moveToNext())


        val tvShowData=findViewById<TextView>(R.id.tvShowData)
        tvShowData.text=builderString
    }

}