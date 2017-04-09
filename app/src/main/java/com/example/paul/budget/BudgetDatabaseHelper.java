package com.example.paul.budget;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by paul on 4/04/17.
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
                "CREATE TABLE accounts (number INTEGER PRIMARY KEY, description TEXT, balance " +
                        "REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
