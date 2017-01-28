package com.techpalle.viewpagerwithdatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 07-Jan-17.
 */
public class MyDatabase {
    MyHelper myHelper;
    SQLiteDatabase sdb;

    public MyDatabase(Context c){
        myHelper = new MyHelper(c, "techpalle.db", null, 1);
    }
    public void open(){
        sdb = myHelper.getWritableDatabase();
    }
    public void insertValue(String name, String subject, String email){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("subject", subject);
        cv.put("email", email);
        sdb.insert("student", null, cv);
    }
    public Cursor queryStudent(){
        Cursor c = null;
        c = sdb.query("student", null, null, null, null, null, null);
        return c;
    }
    public void close(){
        sdb.close();
    }

    private class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table student(_id integer primary key, name text, subject text, email text);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
