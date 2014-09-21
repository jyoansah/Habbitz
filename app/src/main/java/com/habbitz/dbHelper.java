package com.habbitz;

/**
 * Created by Yaw on 2014-09-20.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "tweny1.db";
    private static final int DATABASE_VERSION = 1;

    public static final String ID = "_id";

    public static final String TABLE_USERS = "users";
    public static final String TABLE_TASKS = "tasks";
    public static final String TABLE_CAL = "calendar";

    public static final String FIRST_NAME = "fname";
    public static final String LAST_NAME = "lname";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String TASK_LIST = "tasklist";

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";

    public static final String MKE_BRK = "mkebrk";

    public static final String USER_ID = "userid";
    public static final String TASK_ID = "taskid";
    public static final String START_DATE = "startdate";
    public static final String TASK_COUNT = "taskcount";



    // Database creation sql statements
    private static final String DATABASE_CREATE_USERS = "create table "
            + TABLE_USERS + "("
            + ID + " integer primary key autoincrement, "
            + FIRST_NAME + " text);"
            + LAST_NAME + " text);"
            + USERNAME + " text not null);"
            + PASSWORD + " text not null);"
            + EMAIL + " text not null);"
            + TASK_LIST + " text);";

    private static final String DATABASE_CREATE_TASKS = "create table "
            + TABLE_TASKS + "("
            + ID + " integer primary key autoincrement, "
            + NAME + " text not null);"
            + DESCRIPTION + " text);"
            + MKE_BRK + " text);";

    private static final String DATABASE_CREATE_CAL = "create table "
            + TABLE_CAL + "("
            + ID + " integer primary key autoincrement, "
            + USER_ID + " integer);"
            + TASK_ID + " integer);"
            + START_DATE +  " timestamp);"
            + TASK_COUNT + "integer";

    public dbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(DATABASE_CREATE_USERS);
        db.execSQL(DATABASE_CREATE_TASKS);
        db.execSQL(DATABASE_CREATE_CAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int a, int b){

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAL);

        this.onCreate(db);

    }


}

