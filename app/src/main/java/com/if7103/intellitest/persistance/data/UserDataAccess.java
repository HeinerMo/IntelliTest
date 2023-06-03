package com.if7103.intellitest.persistance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.if7103.intellitest.domain.entity.User;

public class UserDataAccess extends SQLiteOpenHelper implements com.if7103.intellitest.domain.domain.UserDataAccess {

    private String tableName = "tb_users";
    private String userNameColumn = "username";
    private String userPasswordColumn = "password";
    private String activeColumn = "active";

    public UserDataAccess(Context context) {
        super(context, DataBaseInformation.DATABASE_NAME, null, DataBaseInformation.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tableName + " ("
                + userNameColumn + " TEXT PRIMARY KEY NOT NULL,"
                + activeColumn +  " INTEGER NOT NULL,"
                + userPasswordColumn + " TEXT NOT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    @Override
    public void add(Object object) {
        User user = (User) object;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(userNameColumn, user.getUserName());
        contentValues.put(userPasswordColumn, user.getPassword());
        contentValues.put(activeColumn, 1);

        sqLiteDatabase.insert(tableName, null, contentValues);

        sqLiteDatabase.close();
    }

    @Override
    public void update(Object object) {
        User user = (User) object;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(userPasswordColumn, user.getPassword());

        sqLiteDatabase.update(tableName, contentValues, userNameColumn + "=?", new String[]{userNameColumn});
        sqLiteDatabase.close();
    }

    @Override
    public void remove(Object object) {
        User user = (User) object;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(activeColumn, 0);

        sqLiteDatabase.update(tableName, contentValues, userNameColumn + "=?", new String[]{userNameColumn});
        sqLiteDatabase.close();
    }

    @Override
    public User getByUsername(String username) {

        User user = null;
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String query = "SELECT "
                    + userNameColumn
                    + ", " + userPasswordColumn
                    + " FROM " + tableName
                    + " WHERE " + userNameColumn + " == " + "'" + username + "'";

            Cursor cursor = sqLiteDatabase.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                user = new User(cursor.getString(0), cursor.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

}
