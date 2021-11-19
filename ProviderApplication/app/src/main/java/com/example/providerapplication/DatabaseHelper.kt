package com.example.providerapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.providerapplication.MyProvider.Companion.CREATE_DB_TABLE
import com.example.providerapplication.MyProvider.Companion.TABLE_NAME

/**
 * Created by ${nghia.vuong} on 24,July,2021
 */
class DatabaseHelper : SQLiteOpenHelper  {

    constructor(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : super(context, name, factory, version)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_DB_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.let {
            it.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(it)
        }

    }


}