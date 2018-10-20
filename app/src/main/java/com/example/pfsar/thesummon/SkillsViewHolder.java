package com.example.pfsar.thesummon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SkillsViewHolder extends RecyclerView.ViewHolder {

    private final TextView skillTV;

    public SkillsViewHolder(@NonNull View itemView) {
        super(itemView);
        skillTV = itemView.findViewById(R.id.skills_tv);
    }

    public void bindView(String text) {
        skillTV.setText(text);
    }
}
