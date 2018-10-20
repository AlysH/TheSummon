package com.example.pfsar.thesummon;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Education extends AppCompatActivity {

    public Education() {
        educationLevelArray = res.getStringArray(R.array.education_level_array);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
    }

    Resources res = getResources();
    String[] educationLevelArray;
}
