package com.govind8061.simplesimple

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.P)
class MyHelper(context: Context): SQLiteOpenHelper(context, db_name, null, db_version) {

    companion object{
        private val db_name="myDb"
        private val db_version=1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE="CREATE TABLE Products(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,description TEXT,price INTEGER)"
        db?.execSQL(CREATE_TABLE)

        //insert
        insertData("Jam","Fruit Jam",250.6,db!!)
        insertData("Bread","Brown Bread",23.5,db)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(name:String ,description:String,price:Double,db:SQLiteDatabase){
        val map=ContentValues()
        map.put("name",name)
        map.put("description",description)
        map.put("price",price)
        db.insert("Products",null,map)
    }
}