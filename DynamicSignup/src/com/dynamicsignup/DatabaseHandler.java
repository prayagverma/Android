package com.dynamicsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	 
    
    private static final int DATABASE_VERSION = 1;
 
    
    private static final String DATABASE_NAME = "ReaditLater.db";
 
    private static final String TABLE_NAME = "User";
 
    
    private static final String KEY_NAME = "name";
    private static final String KEY_USERID = "userid";
    private static final String KEY_PASS = "pass";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_PHONE = "phone_number";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_STATE = "state";
    private static final String KEY_CITY = "city";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_USERID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PASS + " TEXT," + KEY_GENDER + " TEXT," + KEY_PHONE + " TEXT," + KEY_EMAIL +  " TEXT," +
                KEY_COUNTRY +  " TEXT,"  + KEY_STATE +  " TEXT,"  + KEY_CITY +  " TEXT,"+"SP1 INTEGER,SP2 INTEGER,SP3 INTEGER,SP4 INTEGER" +" )";
        db.execSQL(CREATE_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
    public long add(User user) {
    	
    	SQLiteDatabase db = this.getWritableDatabase();
    	 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());  
        values.put(KEY_PHONE, user.getPhoneNumber());  
        values.put(KEY_CITY, user.getCity());  
        values.put(KEY_COUNTRY, user.getCountry());  
        values.put(KEY_EMAIL, user.getEmail());  
        values.put(KEY_GENDER, user.getGender());  
        values.put(KEY_PASS, user.getPass());  
        values.put(KEY_STATE, user.getState());  
        values.put(KEY_USERID, user.getID()); 
        values.put("SP1", user.getsp1());
        values.put("SP2", user.getsp2());
        values.put("SP3", user.getsp3());
        values.put("SP4", user.getsp4());
        // Inserting Row
     long j=   db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
        return j;
    }
     public User getUser(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_USERID,
                KEY_NAME, KEY_PHONE,KEY_PASS,KEY_GENDER,KEY_EMAIL,KEY_COUNTRY,KEY_CITY,KEY_STATE,"SP1","SP2","SP3","SP4" }, KEY_USERID + "=?",
                new String[] {id}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        User a = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
        		, cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getInt(9)
        		, cursor.getInt(10), cursor.getInt(11),cursor.getInt(12));
        // return contact
        
        return a;
    }
     
     public void deleteContact(String id) {
    	    SQLiteDatabase db = this.getWritableDatabase();
    	    db.delete(TABLE_NAME, KEY_USERID + " = ?",
    	            new String[] {id});
    	    db.close();
    	}
     
     public int updateUser(User user) {
    	    SQLiteDatabase db = this.getWritableDatabase();
    	 
    	    ContentValues values = new ContentValues();
    	    values.put(KEY_NAME, user.getName());  
            values.put(KEY_PHONE, user.getPhoneNumber());  
            values.put(KEY_CITY, user.getCity());  
            values.put(KEY_COUNTRY, user.getCountry());  
            values.put(KEY_EMAIL, user.getEmail());  
            values.put(KEY_GENDER, user.getGender());  
            values.put(KEY_PASS, user.getPass());  
            values.put(KEY_STATE, user.getState());  
            values.put(KEY_USERID, user.getID()); 
            values.put("SP1", user.getsp1());
            values.put("SP2", user.getsp2());
            values.put("SP3", user.getsp3());
            values.put("SP4", user.getsp4());
    	 
    	    // updating row
    	    return db.update(TABLE_NAME, values, KEY_USERID + " = ?",
    	            new String[] { user.getID()} );
    	}
     
     
    
}