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
        radioGroup.setOnCheckedChangeListener(null); // Remove previous listener

        // Add a new listener to handle RadioButton selection
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = group.findViewById(checkedId);
                if (checkedRadioButton != null && checkedRadioButton.isChecked()) {
                    String selectedText = checkedRadioButton.getText().toString();
                    question.setResponse(selectedText);
                }
            }
        });
    }

    public void setQuestion(Question question) {
        this.question = question;
        this.questionHeading.setText(question.getHeading());

        // Set the selected RadioButton if a response is already saved
        String response = question.getResponse();
        if (response != null && !response.isEmpty()) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                if (response.equals(radioButton.getText().toString())) {
                    radioButton.setChecked(true);
                    break;
                }
            }
        } else {
            radioGroup.clearCheck(); // Reset RadioButton selection if no response is saved
        }
    }
}
