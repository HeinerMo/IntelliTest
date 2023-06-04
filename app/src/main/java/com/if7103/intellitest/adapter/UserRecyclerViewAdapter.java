package com.if7103.intellitest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if7103.intellitest.QuestionViewHolder;
import com.if7103.intellitest.R;
import com.if7103.intellitest.UserViewHolder;
import com.if7103.intellitest.domain.entity.User;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserViewHolder>{

    private List<User> users;

    public UserRecyclerViewAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmet_user , parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUser(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
