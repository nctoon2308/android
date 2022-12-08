package com.example.tonapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "TonDemo", null, 6); //tạo db
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table DonHang (orderId integer primary key autoincrement, " +
                "adminId integer DEFAULT 0," +
                "orderCode text DEFAULT ''," +
                "timeIn long DEFAULT 0," +
                "timeOut long DEFAULT 0," +
                "total long DEFAULT 0)";
        db.execSQL(sql);
        sql = "INSERT INTO DonHang Values (null,1,'30x3 39517',100,200,500)";
        db.execSQL(sql);
        sql = "INSERT INTO DonHang Values (null,2,'23x4 39517',400,500,600)";
        db.execSQL(sql);
        sql = "INSERT INTO DonHang Values (null,3,'29x5 39517',700,800,900)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists DonHang");
        onCreate(db);
    }
}
