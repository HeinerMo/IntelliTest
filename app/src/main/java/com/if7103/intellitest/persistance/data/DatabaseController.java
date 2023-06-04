package com.if7103.intellitest.persistance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.if7103.intellitest.domain.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseController extends SQLiteOpenHelper {

    private String tb_users = "tb_users";
    private String userNameColumn = "username";
    private String userPasswordColumn = "password";
    private String activeColumn = "active";
    private String tb_results = "tb_results";
    private String resultsColumn = "results";

    private static DatabaseController databaseController;

    public DatabaseController(@Nullable Context context) {
        super(context, DataBaseInformation.DATABASE_NAME, null, DataBaseInformation.DATABASE_VERSION);
    }

    public static DatabaseController getInstance(Context context) {
        return databaseController == null ? new DatabaseController(context) : databaseController;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + tb_users + " ("
                + userNameColumn + " TEXT PRIMARY KEY NOT NULL,"
                + activeColumn + " INTEGER NOT NULL,"
                + userPasswordColumn + " TEXT NOT NULL)";
        db.execSQL(query);
        query = "CREATE TABLE " + tb_results + " ("
                + userNameColumn + " TEXT PRIMARY KEY NOT NULL,"
                + resultsColumn + " TEXT NOT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + tb_users);
        db.execSQL("DROP TABLE IF EXISTS " + tb_results);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userNameColumn, user.getUserName());
        contentValues.put(userPasswordColumn, user.getPassword());
        contentValues.put(activeColumn, 1);
        sqLiteDatabase.insert(tb_users, null, contentValues);
        sqLiteDatabase.close();
    }

    public void removeUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(activeColumn, 0);
        sqLiteDatabase.update(tb_users, contentValues, userNameColumn + "=?", new String[]{userNameColumn});
        sqLiteDatabase.close();
    }

    public User getByUsername(String username) {
        User user = null;
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT "
                    + userNameColumn
                    + ", " + userPasswordColumn
                    + " FROM " + tb_users
                    + " WHERE " + userNameColumn + " == " + "'" + username + "'";
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                user = new User(cursor.getString(0), cursor.getString(1));
                user.setPoints(this.getUserPoints(user.getUserName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT "
                    + userNameColumn
                    + ", " + userPasswordColumn
                    + " FROM " + tb_users;
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            while (cursor.moveToNext()) {
                User temp = new User(cursor.getString(0), cursor.getString(1));
                //load points
                temp.setPoints(this.getUserPoints(temp.getUserName()));
                users.add(temp);
            }
            cursor.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userPasswordColumn, user.getPassword());
        sqLiteDatabase.update(tb_users, contentValues, userNameColumn + "=?", new String[]{userNameColumn});
        sqLiteDatabase.close();
    }

    public void addUserPoints(User user) {
        //Check if the record exists
        boolean exists = false;
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT "
                    + userNameColumn
                    + ", " + resultsColumn
                    + " FROM " + tb_results
                    + " WHERE " + userNameColumn + " == " + "'" + user.getUserName() + "'";

            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                exists = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String data = integerListToString(user.getPoints());
        if (exists) {
            //update the record
            contentValues.put(resultsColumn, data);
            sqLiteDatabase.update(tb_results, contentValues, userNameColumn + "=?", new String[]{user.getUserName()});
        } else {
            //Create new record
            contentValues.put(userNameColumn, user.getUserName());
            contentValues.put(resultsColumn, data);
            sqLiteDatabase.insert(tb_results, null, contentValues);

        }
        sqLiteDatabase.close();
    }

    public List<Integer> getUserPoints(String username) {
        List<Integer> points = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT "
                    + resultsColumn
                    + " FROM " + tb_results
                    + " WHERE " + userNameColumn + " == " + "'" + username + "'";
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                points = stringToIntegerList(cursor.getString(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return points;
    }

    private String integerListToString(List<Integer> list) {
        String result = "";
        boolean first = true;
        for (Integer integer : list) {
            if (first) {
                result += integer;
                first = false;
            } else {
                result += "~" + integer;
            }
        }
        return result;
    }

    private List<Integer> stringToIntegerList(String data) {
        String[] split = data.split("~");
        Integer[] values = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.parseInt(split[i]);
        }
        return Arrays.asList(values);
    }
}
