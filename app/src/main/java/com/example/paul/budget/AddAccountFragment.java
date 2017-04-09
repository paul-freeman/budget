package com.example.paul.budget;

import android.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by paul on 8/04/17.
 */

public class AddAccountFragment extends Fragment {
    private final BudgetDatabaseHelper dbHelper = new BudgetDatabaseHelper(getActivity());
    private SQLiteDatabase db = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final EditText descriptionBox;
        final EditText balanceBox;

        descriptionBox = (EditText) getActivity().findViewById(R.id.accountDescriptionEditView);
        balanceBox = (EditText) getActivity().findViewById(R.id.accountBalanceEditView);
        Button submitButton = (Button) getActivity().findViewById(R.id.add_account_button);
        submitButton.setOnClickListener(view -> {
                String description = descriptionBox.getText().toString();
                String balance = balanceBox.getText().toString();

            });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_account, container, false);
    }
}
