package com.example.paul.budget;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Results extends Activity {

    private final BudgetDatabaseHelper dbHelper = new BudgetDatabaseHelper(this);
    private SQLiteDatabase db = null;
    private AsyncTask databaseStarter = new StartDatabase().execute();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
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
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.result, new AddAccountFragment())
                        .addToBackStack(null)
                        .commit();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        db = null;
        super.onDestroy();
    }

    private class StartDatabase extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            db = dbHelper.getWritableDatabase();
            return true;
        }
    }
}
