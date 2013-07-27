package com.later;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databases extends SQLiteOpenHelper {
	 
    
    private static final int DATABASE_VERSION = 1;
 
    
    private static final String DATABASE_NAME = "ReaditLater.db";
 
    private static final String TABLE_NAME = "List";
 
    private static final String KEY_TITLE = "title";
    private static final String KEY_URL = "url";
    private static final String KEY_ID = "id";
     
 
    public Databases(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_URL + " TEXT ,"+ KEY_TITLE +" TEXT" +" )";
        db.execSQL(CREATE_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
    public long add(URLs user) {
    	
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_URL, user.getName().toString());  
        values.put(KEY_TITLE, user.getTitle()); 
         
        // Inserting Row
     long j=   db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return j;
    }
    
    
     public List<URLs> getUser() {
     	 List<URLs> a= new ArrayList<URLs>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
         Cursor cursor =   db.rawQuery(selectQuery, null);
         
         if (cursor.moveToFirst()) {
             do {
                 URLs contact = new URLs();
                 contact.setName(cursor.getString(1));
                 contact.setTitle(cursor.getString(2));
                 // Adding contact to list
                 a.add(contact);
             } while (cursor.moveToNext());
         }
         db.close();
         
        return a;
    }
     
     
    
}