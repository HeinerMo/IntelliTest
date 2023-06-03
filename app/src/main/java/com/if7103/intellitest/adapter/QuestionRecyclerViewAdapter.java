package com.if7103.intellitest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if7103.intellitest.QuestionViewHolder;
import com.if7103.intellitest.R;
import com.if7103.intellitest.domain.entity.Question;
import com.if7103.intellitest.persistance.data.QuestionDataAccess;

import java.util.ArrayList;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionViewHolder> {

    private Context localContext;
    private QuestionDataAccess questionDataAccess;

    public QuestionRecyclerViewAdapter(Context localContext) {
        this.localContext = localContext;
        questionDataAccess = QuestionDataAccess.getInstance();
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_question , parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.setQuestion(questionDataAccess.getQuestions().get(position));
    }

    @Override
    public int getItemCount() {
        return questionDataAccess.getQuestions().size();
    }
}
