package com.example.pfsar.thesummon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Skills extends AppCompatActivity {

    private RecyclerView skillsRV;
    private SkillsAdapter skillsAdapter;
    private ArrayList<String> skills;
    private EditText skillsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        skillsRV = findViewById(R.id.skills_rv);
        skillsET = findViewById(R.id.new_skill_et);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        skillsRV.setLayoutManager(layoutManager);
        skills = new ArrayList<>();
        skills.add("fly");
        skills.add("destroy");
        skills.add("java");
        skillsAdapter = new SkillsAdapter(skills);
        skillsRV.setAdapter(skillsAdapter);
        skillsAdapter.notifyDataSetChanged();
        skillsET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    skills.add(skillsET.getText().toString());
                    skillsET.setText("");
                    skillsAdapter.notifyDataSetChanged();
                }
                return false;
            }
        });
    }
}
