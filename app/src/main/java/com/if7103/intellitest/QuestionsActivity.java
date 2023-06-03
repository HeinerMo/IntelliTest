package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.if7103.intellitest.adapter.QuestionRecyclerViewAdapter;
import com.if7103.intellitest.domain.entity.Question;
import com.if7103.intellitest.persistance.data.QuestionDataAccess;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    private RecyclerView recyclerQuestions;
    private QuestionRecyclerViewAdapter questionRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        recyclerQuestions = this.findViewById(R.id.recyclerQuestions);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerQuestions.setLayoutManager(linearLayoutManager);

        questionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(this);
        recyclerQuestions.setAdapter(questionRecyclerViewAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerQuestions);
    }

    public void checkQuestions(View view) {
        ArrayList<Question> questions = QuestionDataAccess.getInstance().getQuestions();
        for (Question question: questions) {
            if (!question.validResponse()) {
                recyclerQuestions.smoothScrollToPosition(questions.indexOf(question));
                Snackbar.make(view, "Debe completar todas las opciones", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }
    }
}