package com.example.lab10;

import android.provider.BaseColumns;

public final class CourseApp {

    private CourseApp(){}

    public static class Users implements BaseColumns{

        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_TYPE = "type";
    }

    public static class Messages implements BaseColumns{

        public static final String TABLE_NAME = "Messages";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_USER = "user";
        public static final String COLUMN_NAME_SUBJECT = "subject";
        public static final String COLUMN_NAME_MESSAGE = "message";
    }


}
