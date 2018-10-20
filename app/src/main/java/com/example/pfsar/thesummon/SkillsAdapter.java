package com.example.pfsar.thesummon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter {

    private List<String> skills;

    public SkillsAdapter(List<String> skills) {
        this.skills = skills;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SkillsViewHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.viewholder_skills, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((SkillsViewHolder) viewHolder).bindView(skills.get(i));
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}
