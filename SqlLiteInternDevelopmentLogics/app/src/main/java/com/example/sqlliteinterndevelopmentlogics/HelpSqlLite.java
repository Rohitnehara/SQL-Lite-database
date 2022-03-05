package com.example.sqlliteinterndevelopmentlogics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelpSqlLite extends SQLiteOpenHelper {
    public HelpSqlLite( Context context) {
        super(context,"Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
DB.execSQL("create Table Userdetails(id INTEGER primary key autoincrement, UserName TEXT ,Email TEXT )");
}

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
     DB.execSQL("drop table if exists Userdetails");
    }
    public Boolean insertuserData(String UserName,String Email){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("UserName",UserName);
        contentValues.put("Email",Email);
        long result =DB.insert("Userdetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        String quary="Select * from Userdetails order by id desc";
        Cursor cursor = DB.rawQuery(quary,null);
        return cursor;
    }
}
