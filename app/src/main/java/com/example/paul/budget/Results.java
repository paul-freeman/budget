package com.example.paul.budget;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paul.budget.database.BudgetDatabaseHelper;

import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_BALANCE;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.TABLE_ACCOUNTS;

public class Results extends Activity {

    public SQLiteDatabase db = null;
    private BudgetDatabaseHelper dbHelper = null;
    private AsyncTask<Void, Void, Boolean> startDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new BudgetDatabaseHelper(this);
        startDB = new StartDatabase().execute();
        setContentView(R.layout.activity_results);
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db = null;
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.results_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.result, new BudgetPreferenceFragment())
                        .addToBackStack(null)
                        .commit();
                return true;
            case R.id.add_account:
                if (db == null) {
                    Toast
                            .makeText(this, "database not ready yet", Toast.LENGTH_LONG)
                            .show();
                    return true;
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.result, new AddAccountFragment())
                        .addToBackStack(null)
                        .commit();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class StartDatabase extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            db = dbHelper.getWritableDatabase();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            String[] projection = {COLUMN_DESCRIPTION, COLUMN_BALANCE};
            Cursor cursor = db.query(TABLE_ACCOUNTS, projection, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                LinearLayout layout = (LinearLayout) findViewById(R.id.account_scroll);
                for (int i = 0; i < cursor.getCount(); i++) {
                    TextView account = new TextView(getBaseContext());
                    String description = cursor.getString(0);
                    String balance = cursor.getString(1);
                    String text = description + " " + balance;
                    account.setText(text);
                    layout.addView(account);
                    cursor.moveToNext();
                }
            }

            cursor.close();
        }
    }
}
