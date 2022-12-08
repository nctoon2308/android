package com.example.tonapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Timestamp;
import java.util.ArrayList;

public class DonHangDAO {
    public static ArrayList<DonHang> getAll(Context context){
        ArrayList<DonHang> ds = new ArrayList<>();
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM DonHang WHERE timeOut = 0", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int orderId = cs.getInt(0);
            int adminId = cs.getInt(1);
            String orderCode = cs.getString(2);
            long timeIn = cs.getLong(3);
            long timeOut = cs.getLong(4);
            long total = cs.getLong(5);
            DonHang dh = new DonHang(orderId, adminId, orderCode, timeIn, timeOut, total);
            ds.add(dh);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return ds;
    }

    public static boolean insert(Context context, int adminId, String orderCode, long timeIn){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("adminId", adminId);
        values.put("orderCode", orderCode);
        values.put("timeIn", timeIn);
        long row = db.insert("DonHang", null, values);
        return (row > 0);
    }

    public static boolean out(Context context, DonHang dh){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        long timeOut = timestamp.getTime();
        values.put("timeOut", timeOut);
        int row = db.update("DonHang", values, "orderId=?", new String[]{dh.getOrderId() + ""});
        return (row > 0);
    }

    public static boolean update(Context context, DonHang dh){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("orderCode", dh.getOrderCode());
        int row = db.update("DonHang", values, "orderId=?", new String[]{dh.getOrderId() + ""});
        return (row > 0);
    }

    public static boolean delete(Context context, int orderId){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("DonHang", "orderId=?", new String[]{orderId + ""});
        return (row > 0);
    }
}
