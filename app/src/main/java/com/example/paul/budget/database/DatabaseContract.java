package com.example.paul.budget.database;

import android.provider.BaseColumns;

/**
 * Constants related to the Budget Database.
 */

public class DatabaseContract {
    private DatabaseContract() {
    }

    public static class DatabaseEntry implements BaseColumns {
        public static final String TABLE_ACCOUNTS = "accounts";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_BALANCE = "balance";
    }
}
