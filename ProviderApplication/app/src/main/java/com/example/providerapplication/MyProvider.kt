package com.example.providerapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.util.Log
import java.util.*


/**
 * Created by ${nghia.vuong} on 22,July,2021
 */
class MyProvider : ContentProvider() {

    companion object {
        private const val TAG = "MyProvider"
        const val PROVIDER_NAME = "com.example.providerapplication.MyProvider"
        const val CONTENT_URL = "content://${PROVIDER_NAME}/cte"

        const val DATABASE_NAME = "sharedDB"
        const val TABLE_NAME = "names"
        const val DATABASE_VERSION = 1
        const val CREATE_DB_TABLE = "CREATE TABLE $TABLE_NAME (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);"

        val uri: Uri = Uri.parse(CONTENT_URL)
        const val id = "id"
        const val name = "name"
        const val uriCode = 1
        val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        val values = HashMap<String, String>()
    }


    init {
        uriMatcher.addURI(PROVIDER_NAME, "cte", uriCode)
        uriMatcher.addURI(PROVIDER_NAME, "cte/*", uriCode)
    }

    private lateinit var db: SQLiteDatabase

    override fun onCreate(): Boolean {
        Log.d(TAG, "onCreate: ")
        val context = context
        val dbHelper = DatabaseHelper(context, TABLE_NAME, null, DATABASE_VERSION)
        db = dbHelper.writableDatabase
        return db != null
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
        Log.d(TAG, "query: ")

        val qb = SQLiteQueryBuilder()
        qb.tables = TABLE_NAME

        if (uriMatcher.match(uri) == uriCode) {
            qb.projectionMap = values
        } else {
            throw IllegalArgumentException("Unknown URI $uri")
        }

        val c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder ?: name)
        c.setNotificationUri(requireContext().contentResolver, uri)

        return c

    }

    override fun getType(p0: Uri): String? {
        Log.d(TAG, "getType: ")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        Log.d(TAG, "insert: ")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        Log.d(TAG, "delete: ")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        Log.d(TAG, "update: ")
    }


}

