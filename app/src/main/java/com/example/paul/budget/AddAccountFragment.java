package com.example.paul.budget;

import android.app.Fragment;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_BALANCE;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.COLUMN_DESCRIPTION;
import static com.example.paul.budget.database.DatabaseContract.DatabaseEntry.TABLE_ACCOUNTS;

/**
 * Activity used to add a new account to the database.
 */

public class AddAccountFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_account, container, false);

        Button submitButton = (Button) view.findViewById(R.id.add_account_button);
        submitButton.setOnClickListener(v -> {
            EditText descriptionBox = (EditText) view.findViewById(R.id.accountDescriptionEditView);
            EditText balanceBox = (EditText) view.findViewById(R.id.accountBalanceEditView);
            ContentValues values = new ContentValues();
            values.put(COLUMN_DESCRIPTION, descriptionBox
                    .getText()
                    .toString());
            values.put(COLUMN_BALANCE, balanceBox
                    .getText()
                    .toString());
            ((Results) getActivity()).db.insert(TABLE_ACCOUNTS, null, values);
            getFragmentManager().popBackStack();
        });

        return view;
    }
}
