package com.habbitz;

/**
 * Created by Yaw on 2014-09-20.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class dbSource {

    // Database fields
    private SQLiteDatabase database;
    private com.habbitz.dbHelper dbHelper;
    private String[] userColumns = { dbHelper.ID, dbHelper.FIRST_NAME, dbHelper.LAST_NAME, dbHelper.EMAIL , dbHelper.PASSWORD};
    private String[] taskColumns = { dbHelper.ID, dbHelper.NAME};
    private String[] calColumns = { dbHelper.ID, dbHelper.NAME};

    public dbSource(Context context){
        dbHelper = new dbHelper(context);
    }

    public void close() {
        dbHelper.close();
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }


    //USER TABLE
    public Profile createUser(Profile user) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.FIRST_NAME, user.getFirstName());
        values.put(dbHelper.LAST_NAME, user.getLastName());
        values.put(dbHelper.USERNAME, user.getUsername());
        values.put(dbHelper.PASSWORD, user.getPassword());
        values.put(dbHelper.EMAIL, user.getEmail());
        values.put(dbHelper.TASK_LIST, user.getTaskList());

        long insertId = database.insert(dbHelper.TABLE_USERS, null, values);
        Cursor cursor = database.query(dbHelper.TABLE_USERS,
                userColumns, dbHelper.ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Profile newProfile = cursorToProfile(cursor);
        cursor.close();
        return newProfile;
    }

    public void deleteProfile(Profile user) {
        long id = user.getId();
        System.out.println("User deleted with id: " + id);
        database.delete(dbHelper.TABLE_USERS, dbHelper.ID
                + " = " + id, null);
    }

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<Profile>();

        Cursor cursor = database.query(dbHelper.TABLE_USERS,
                userColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Profile user = cursorToProfile(cursor);
            profiles.add(user);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return profiles;
    }

    private Profile cursorToProfile(Cursor cursor) {
        Profile profile = new Profile();
        profile.setId(cursor.getLong(0));
        profile.setFirstName(cursor.getString(1));
        profile.setLastName(cursor.getString(2));
        profile.setUsername(cursor.getString(3));
        profile.setPassword(cursor.getString(4));
        profile.setEmail(cursor.getString(5));
        profile.setTaskList(cursor.getString(6));
        return profile;
    }



    //TASKS TABLE
    public Task createTask(Task task) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.NAME, task.getName());
        values.put(dbHelper.DESCRIPTION, task.getDescription());
        values.put(dbHelper.MKE_BRK, task.getMkeBrk());

        long insertId = database.insert(dbHelper.TABLE_TASKS, null, values);
        Cursor cursor = database.query(dbHelper.TABLE_TASKS,
                taskColumns, dbHelper.ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Task newTask = cursorToTask(cursor);
        cursor.close();
        return newTask;
    }

    public void deleteTask(Task task) {
        long id = task.getId();
        System.out.println("Task deleted with id: " + id);
        database.delete(dbHelper.TABLE_TASKS, dbHelper.ID
                + " = " + id, null);
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<Task>();

        Cursor cursor = database.query(dbHelper.TABLE_TASKS,
                taskColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Task task = cursorToTask(cursor);
            tasks.add(task);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return tasks;
    }

    private Task cursorToTask(Cursor cursor) {
        Task task = new Task();
        task.setId(cursor.getLong(0));
        task.setName(cursor.getString(1));
        task.setDescription(cursor.getString(2));
        task.setMkeBrk(Boolean.parseBoolean(cursor.getString(3)));
        return task;
    }

    public ArrayList<Task> getUserTasks (long user_id){

        Cursor cursor = database.query(dbHelper.TABLE_USERS,
                userColumns, dbHelper.ID + " = " + user_id, null, null, null, null);
        cursor.moveToFirst();

        Profile user = cursorToProfile(cursor);

        String [] taskList = user.getTaskList().split(";");

        ArrayList<Task> tasks = new ArrayList<Task>();

        for(int i = 0; i < taskList.length; i++){
            Cursor tsk_cursor = database.query(dbHelper.TABLE_TASKS,
                    taskColumns, dbHelper.ID + " = " + taskList[i], null, null, null, null);
            tasks.add(cursorToTask(tsk_cursor));
        }

        return tasks;

    }



    //CAL TABLE
    public Cal createCal(Cal cal) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.USER_ID, cal.getUserId());
        values.put(dbHelper.TASK_ID, cal.getTaskId());
        values.put(dbHelper.START_DATE, cal.getDateStarted());
        values.put(dbHelper.TASK_COUNT, cal.getTaskCount());

        long insertId = database.insert(dbHelper.TABLE_CAL, null, values);
        Cursor cursor = database.query(dbHelper.TABLE_CAL,
                calColumns, dbHelper.ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Cal newCal = cursorToCal(cursor);
        cursor.close();
        return newCal;
    }

    public void deleteCal(Cal cal) {
        long id = cal.getId();
        System.out.println("Cal deleted with id: " + id);
        database.delete(dbHelper.TABLE_CAL, dbHelper.ID
                + " = " + id, null);
    }

    public ArrayList<Cal> getAllUserCals(Cal user) {
        ArrayList<Cal> cals = new ArrayList<Cal>();

        Cursor cursor = database.query(dbHelper.TABLE_CAL,
                calColumns, dbHelper.USER_ID + "=" + user.getId() , null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cal cal = cursorToCal(cursor);
            cals.add(cal);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return cals;
    }

    private Cal cursorToCal(Cursor cursor) {
        Cal cal = new Cal();
        cal.setId(cursor.getLong(0));
        cal.setUserId(cursor.getLong(1));
        cal.setTaskId(cursor.getLong(2));
        cal.setDateStarted(cursor.getLong(3));
        cal.setTaskCount(cursor.getString(4));
        return cal;
    }

    public ArrayList<Cal> getUserActiveTasks(long user_id, long task_id){

        ArrayList<Cal> cals = new ArrayList<Cal>();

        String where = dbHelper.USER_ID + "=" + user_id;
        where += (task_id <= 0)?dbHelper.TASK_ID + "=" + task_id:"";

        Cursor cursor = database.query(dbHelper.TABLE_CAL,
                calColumns, where, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Cal cal = cursorToCal(cursor);
            cals.add(cal);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return cals;
    }

}
