package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.if7103.intellitest.adapter.QuestionRecyclerViewAdapter;
import com.if7103.intellitest.domain.domain.ApplicationData;
import com.if7103.intellitest.domain.entity.Question;
import com.if7103.intellitest.persistance.data.DatabaseController;
import com.if7103.intellitest.persistance.data.QuestionDataAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private RecyclerView recyclerQuestions;
    private QuestionRecyclerViewAdapter questionRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //fill();

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
        //Check if all questions have been answered.
        ArrayList<Question> questions = QuestionDataAccess.getInstance().getQuestions();
        for (Question question : questions) {
            if (!question.validResponse()) {
                recyclerQuestions.smoothScrollToPosition(questions.indexOf(question));
                Snackbar.make(view, "Debe completar todas las opciones", Snackbar.LENGTH_SHORT).show();
                return;
            }
        }

        //Handle answers
        Integer[] points = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Question question : questions) {
            switch (question.getIntelligence().getName()) {
                case "Espacial":
                    points[0] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Musical":
                    points[1] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Lingüístico-verbal":
                    points[2] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Lógico-matemático":
                    points[3] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Corporal-cinestésico":
                    points[4] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Intrapersonal":
                    points[5] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Interpersonal":
                    points[6] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Naturalista":
                    points[7] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Existencial":
                    points[8] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Creativo":
                    points[9] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Emocional":
                    points[10] += question.getOption(question.getResponse()).getValue();
                    break;
                case "Colaborativo":
                    points[11] += question.getOption(question.getResponse()).getValue();
                    break;
            }
        }
        for (int i = 0; i < points.length; i++) {
            points[i] /= 3;
        }
        ApplicationData.getData().getUser().setPoints(Arrays.asList(points));
        DatabaseController databaseController = DatabaseController.getInstance(this);
        databaseController.addUserPoints(ApplicationData.getData().getUser());


        //launch results activity
        Intent intent = new Intent(QuestionsActivity.this, ResultsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /*
    public void fill() {
        List<Question> questions = QuestionDataAccess.getInstance().getQuestions();
        for(Question q: questions) {
            q.setResponse(q.getOptions()[2].getOption());
        }
    }
    */

}