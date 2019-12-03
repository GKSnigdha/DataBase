package com.example.snikdha.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    public static String DATA_BASE= "employee";
    public static String TABLE_NAME= "info";

    public static String COL_NAME= "name";
    public static String COL_PHONE= "phone";
    public static String COL_AGE= "age";


    public SQLHelper(Context context) {
        super(context, DATA_BASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" ( " + COL_NAME + " TEXT , " + COL_PHONE + " TEXT, "+ COL_AGE+ " TEXT )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertValue( ObjectForEmployee objectForEmployee){
        String name = objectForEmployee.getName();
        String phone = objectForEmployee.getPhone();
        String age = objectForEmployee.getAge();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_PHONE,phone);
        contentValues.put(COL_AGE,age);


        long inserted = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return inserted;
    }

    public Cursor read(){
        String sql = " select * from " + TABLE_NAME ;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;

    }
    public  int delete(String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int deleted = sqLiteDatabase.delete(TABLE_NAME, "phone = "+phone, null);
        return deleted;
    }

    public int update(String name,String phone,String age){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_AGE,age);
        int updated = sqLiteDatabase.update(TABLE_NAME, contentValues, " phone = "+phone, null);
        return updated;
    }
}
