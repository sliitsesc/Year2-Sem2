package com.example.modelpaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME = "MAD_MODEL.db";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE =
                "CREATE TABLE "+ UserProfile.Users.TABLE_NAME+"("
                + UserProfile.Users.COLUMN_NAME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserProfile.Users.COLUMN_NAME_USERNAME+ " TEXT,"
                + UserProfile.Users.COLUMN_NAME_PASSWORD+ " TEXT,"
                + UserProfile.Users.COLUMN_NAME_DATEOFBIRTH+ " TEXT,"
                        + UserProfile.Users.COLUMN_NAME_GENDER+ " CHARACTER);";

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ UserProfile.Users.TABLE_NAME);
        onCreate(db);
    }

    public boolean addInfo(UserProfile user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.COLUMN_NAME_USERNAME,user.getUserName());
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD,user.getPassword());
        values.put(UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,user.getDob());
        values.put(UserProfile.Users.COLUMN_NAME_GENDER, String.valueOf(user.getGender()));

        long result = db.insert(UserProfile.Users.TABLE_NAME,null,values);

        if(result>0){
            return true;
        }
        else
            return false;

    }

    public boolean updateInfo(UserProfile user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.COLUMN_NAME_USERNAME,user.getUserName());
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD,user.getPassword());
        values.put(UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,user.getDob());
        values.put(UserProfile.Users.COLUMN_NAME_GENDER, String.valueOf(user.getGender()));
        String selection = UserProfile.Users.COLUMN_NAME_ID +" = ?";
        String[] selectionArgs = {String.valueOf(user.getId())};

        int count = db.update(
                UserProfile.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        if(count>0){
            return true;
        }
        else{
            return false;
        }

    }

    public List readAllInfo(){
        SQLiteDatabase db =this.getReadableDatabase();
        List<UserProfile> users = new ArrayList<>();
        String[] projection = {
                UserProfile.Users.COLUMN_NAME_ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,
                UserProfile.Users.COLUMN_NAME_PASSWORD,
                UserProfile.Users.COLUMN_NAME_GENDER
        };
        Cursor res = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while(res.moveToNext()){
            UserProfile user = new UserProfile();

            user.setId(res.getInt(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_ID)));
            user.setUserName(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_USERNAME)));
            user.setDob(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_DATEOFBIRTH)));
            user.setPassword(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_PASSWORD)));
            user.setGender(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_GENDER)));
            users.add(user);
        }
        return users;
    }

    public UserProfile readAllInfo(int id){
        SQLiteDatabase db =this.getReadableDatabase();

        UserProfile user = new UserProfile();
        String[] projection = {
                UserProfile.Users.COLUMN_NAME_ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,
                UserProfile.Users.COLUMN_NAME_GENDER
        };
        Cursor res = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                "_ID = ?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null
        );

        while(res.moveToNext()){
            user.setId(res.getInt(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_ID)));
            user.setUserName(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_USERNAME)));
            user.setDob(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_DATEOFBIRTH)));
            user.setGender(res.getString(res.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_GENDER)));
        }
        return user;
    }

    public boolean deleteInfo(Integer id){
        SQLiteDatabase db =  this.getWritableDatabase();
        String selection = UserProfile.Users.COLUMN_NAME_ID +"= ?";
        String[] selectionArgs = {id.toString()};
        long result = db.delete(
                UserProfile.Users.TABLE_NAME,
                selection,
                selectionArgs
        );

        if(result>0){
            return true;
        }
        else
            return false;
    }

}
