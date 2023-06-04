package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.if7103.intellitest.adapter.QuestionRecyclerViewAdapter;
import com.if7103.intellitest.adapter.UserRecyclerViewAdapter;
import com.if7103.intellitest.domain.domain.ApplicationData;
import com.if7103.intellitest.domain.domain.IntelligenceClassifier;
import com.if7103.intellitest.domain.entity.User;

import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private TextView textResult;

    private UserRecyclerViewAdapter userRecyclerViewAdapter;
    private UserViewHolder userViewHolder;
    private RecyclerView userRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textResult = this.findViewById(R.id.textResult);
        userRecyclerView = this.findViewById(R.id.userRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        userRecyclerView.setLayoutManager(linearLayoutManager);

        List<User> sortedUsers = IntelligenceClassifier.sortPlayersByIntelligence(ApplicationData.getData().getUser(), this);
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(sortedUsers);
        userRecyclerView.setAdapter(userRecyclerViewAdapter);

        loadResult();
    }

    private void loadResult() {
        String intelligence = IntelligenceClassifier.getPredominantIntelligenceType(ApplicationData.getData().getUser().getPoints());
        textResult.setText(ApplicationData.getData().getUser().getUserName() + " tu inteligencia es: " + intelligence + "\n Eres compatible con: ");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultsActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}