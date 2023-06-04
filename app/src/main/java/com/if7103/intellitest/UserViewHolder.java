package com.if7103.intellitest;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if7103.intellitest.domain.domain.IntelligenceClassifier;
import com.if7103.intellitest.domain.entity.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private User user;
    private TextView textUserName, textUserIntelligence;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textUserName = itemView.findViewById(R.id.textUserNameResults);
        textUserIntelligence = itemView.findViewById(R.id.textUserIntelligenceResults);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        textUserName.setText(user.getUserName());
        textUserIntelligence.setText(IntelligenceClassifier.getPredominantIntelligenceType(user.getPoints()));
    }
}
