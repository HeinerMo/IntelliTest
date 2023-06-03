package com.if7103.intellitest;

import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if7103.intellitest.domain.entity.Question;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    private Question question;
    private TextView questionHeading;
    private RadioGroup radioGroup;

    public QuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        questionHeading = itemView.findViewById(R.id.questionHeading);
        radioGroup = itemView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle RadioButton selection
                RadioButton checkedRadioButton = group.findViewById(checkedId);
                if (checkedRadioButton != null) {
                    // RadioButton is selected
                    String selectedText = checkedRadioButton.getText().toString();
                    question.setResponse(selectedText);
                }
            }
        });
    }

    public void setQuestion(Question question) {
        this.question = question;
        this.questionHeading.setText(question.getHeading());
    }
}
