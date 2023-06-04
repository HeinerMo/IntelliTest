package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.if7103.intellitest.persistance.data.QuestionDataAccess;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchQuestionnaire(View view) {
        QuestionDataAccess.getInstance().clearOptions();
        Intent myIntent = new Intent(HomeActivity.this, QuestionsActivity.class);
        HomeActivity.this.startActivity(myIntent);
    }

    public void signOut(View view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void launchResultsActivity(View view) {
        //launch results activity
        Intent intent = new Intent(HomeActivity.this, ResultsActivity.class);
        startActivity(intent);
    }
}