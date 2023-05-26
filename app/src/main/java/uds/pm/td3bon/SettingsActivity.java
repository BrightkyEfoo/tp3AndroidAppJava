package uds.pm.td3bon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }





    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        private ListPreference textSizePreference;
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            textSizePreference = findPreference("list_preference_1");
            textSizePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
//                    System.out.print();
                    Log.println(Log.INFO , "onPreferenceTreeClick" , "preference : "+newValue.toString());

                    return true;
                }
            });
        }


//        @Override
//        public boolean onPreferenceTreeClick(@NonNull Preference preference) {
//            Log.println(Log.INFO , "onPreferenceTreeClick" , "preference : "+preference.getKey());
////            ;
////            if (preference.getKey().equals(findPreference().getKey())){
////
////            }
//            return super.onPreferenceTreeClick(preference);
//        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        Log.println(Log.INFO , "onOptionsItemSelected" , "item : "+item.getItemId());
////        if(item.getItemId() == ){
////            Intent goToSettingIntent = new Intent(this , SettingsActivity.class);
////            startActivity(goToSettingIntent);
////        }
//
//        return super.onOptionsItemSelected(item);
//
//    }
}