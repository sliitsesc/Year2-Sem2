package com.example.lab10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Lab10.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE "+ CourseApp.Users.TABLE_NAME+"("
                + CourseApp.Users.COLUMN_NAME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CourseApp.Users.COLUMN_NAME_NAME+" TEXT,"
                + CourseApp.Users.COLUMN_NAME_PASSWORD+" TEXT,"
                + CourseApp.Users.COLUMN_NAME_TYPE+" TEXT)";

        String CREATE_MESSAGES_TABLE = "CREATE TABLE "+ CourseApp.Messages.TABLE_NAME+"("
                + CourseApp.Messages.COLUMN_NAME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CourseApp.Messages.COLUMN_NAME_USER+" TEXT,"
                + CourseApp.Messages.COLUMN_NAME_SUBJECT+" TEXT,"
                + CourseApp.Messages.COLUMN_NAME_MESSAGE+" TEXT)";

        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_MESSAGES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DELETE_USERS =
                "DROP TABLE IF EXISTS " + CourseApp.Users.TABLE_NAME;
        String DELETE_MESSAGES =
                "DROP TABLE IF EXISTS " + CourseApp.Messages.TABLE_NAME;

        db.execSQL(DELETE_USERS);
        db.execSQL(DELETE_MESSAGES);
        onCreate(db);

    }

    public boolean register(User user,String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(CourseApp.Users.COLUMN_NAME_NAME,user.getName());
        values.put(CourseApp.Users.COLUMN_NAME_PASSWORD,password);
        values.put(CourseApp.Users.COLUMN_NAME_TYPE,user.getType());

        long newRowID = db.insert(CourseApp.Users.TABLE_NAME,null,values);

        if(newRowID>0){
            return true;
        }
        else{
            return  false;
        }

    }


    public boolean addMessage(MessageModel message){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(CourseApp.Messages.COLUMN_NAME_USER,message.getUser());
        values.put(CourseApp.Messages.COLUMN_NAME_SUBJECT,message.getSubject());
        values.put(CourseApp.Messages.COLUMN_NAME_MESSAGE,message.getMessage());

        long newRowID = db.insert(CourseApp.Messages.TABLE_NAME,null,values);

        if(newRowID>0){
            return true;
        }
        else{
            return  false;
        }

    }

    public List<MessageModel> retrieveMessages(){
        SQLiteDatabase db = getReadableDatabase();
        List<MessageModel> messages = new ArrayList<>();

        String[] projection = {
          CourseApp.Messages.COLUMN_NAME_ID,
          CourseApp.Messages.COLUMN_NAME_USER,
          CourseApp.Messages.COLUMN_NAME_SUBJECT,
          CourseApp.Messages.COLUMN_NAME_MESSAGE
        };

        Cursor res = db.query(
                CourseApp.Messages.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (res.moveToNext()){
            MessageModel message = new MessageModel();

            message.setId(res.getInt(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_ID)));
            message.setUser(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_USER)));
            message.setSubject(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_SUBJECT)));
            message.setMessage(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_MESSAGE)));

            messages.add(message);
        }

        return messages;

    }

    public MessageModel getLatestMessage(){
        SQLiteDatabase db = getReadableDatabase();
        MessageModel latestMessage = new MessageModel();

        String[] projection = {
                CourseApp.Messages.COLUMN_NAME_ID,
                CourseApp.Messages.COLUMN_NAME_USER,
                CourseApp.Messages.COLUMN_NAME_SUBJECT,
                CourseApp.Messages.COLUMN_NAME_MESSAGE
        };


        Cursor res = db.query(
                CourseApp.Messages.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                CourseApp.Messages.COLUMN_NAME_ID +"DESC",
                String.valueOf(1)
        );

        while (res.moveToNext()){

            latestMessage.setId(res.getInt(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_ID)));
            latestMessage.setUser(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_USER)));
            latestMessage.setSubject(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_SUBJECT)));
            latestMessage.setMessage(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_MESSAGE)));


        }

        return latestMessage;


    }

    public User login(String username,String passowrd){

        SQLiteDatabase db = getReadableDatabase();
        User user = new User();
        String[] projection = {
          CourseApp.Users.COLUMN_NAME_ID,
          CourseApp.Users.COLUMN_NAME_NAME,
          CourseApp.Users.COLUMN_NAME_TYPE
        };

        String selection = CourseApp.Users.COLUMN_NAME_NAME + " = ?"+" AND "+CourseApp.Users.COLUMN_NAME_PASSWORD + " = ?";

        String[] selectionArgs = {username,passowrd};
        Cursor res = db.query(
                CourseApp.Users.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int cursorCount = res.getCount();

        if(cursorCount>0){
            while(res.moveToNext()){
                user.setId(res.getInt(res.getColumnIndexOrThrow(CourseApp.Users.COLUMN_NAME_ID)));
                user.setName(res.getString(res.getColumnIndexOrThrow(CourseApp.Users.COLUMN_NAME_NAME)));
                user.setType(res.getString(res.getColumnIndexOrThrow(CourseApp.Users.COLUMN_NAME_TYPE)));
            }
        }

        return  user;
    }




    public MessageModel getMessage(int id){
        SQLiteDatabase db = getReadableDatabase();
        MessageModel message = new MessageModel();

        String[] projection = {
                CourseApp.Messages.COLUMN_NAME_ID,
                CourseApp.Messages.COLUMN_NAME_USER,
                CourseApp.Messages.COLUMN_NAME_SUBJECT,
                CourseApp.Messages.COLUMN_NAME_MESSAGE
        };

        String selection = CourseApp.Messages.COLUMN_NAME_ID+"=?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor res = db.query(
                CourseApp.Messages.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null,
                String.valueOf(1)
        );

        while (res.moveToNext()){

            message.setId(res.getInt(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_ID)));
            message.setUser(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_USER)));
            message.setSubject(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_SUBJECT)));
            message.setMessage(res.getString(res.getColumnIndexOrThrow(CourseApp.Messages.COLUMN_NAME_MESSAGE)));


        }

        return message;


    }




}
