package com.example.paul.budget;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Budget user settings.
 */

public class BudgetPreferenceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.budget_preference_view);
    }
}
