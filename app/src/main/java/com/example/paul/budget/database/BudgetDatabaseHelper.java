package com.example.paul.budget.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_BALANCE;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.TABLE_ACCOUNTS;

/**
 * Budget Database helper (creation/upgrade) methods.
 */

public class BudgetDatabaseHelper extends SQLiteOpenHelper {

    private static final String NAME = "BudgetDatabase.db";
    private static final int VERSION = 1;

    public BudgetDatabaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_ACCOUNTS + " (" + _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_DESCRIPTION + " TEXT, " + COLUMN_BALANCE + " REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
