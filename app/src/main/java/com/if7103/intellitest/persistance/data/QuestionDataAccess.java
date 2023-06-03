package com.if7103.intellitest.persistance.data;

import com.if7103.intellitest.domain.entity.Question;

import java.util.ArrayList;

public class QuestionDataAccess {


    private ArrayList<Question> questions;
    private static QuestionDataAccess questionDataAccess;

    private QuestionDataAccess() {
        questions = new ArrayList<>();
        questions.add(new Question("Heading 1"));
        questions.add(new Question("Heading 2"));
        questions.add(new Question("Heading 3"));
        questions.add(new Question("Heading 4"));
        questions.add(new Question("Heading 5"));
        questions.add(new Question("Heading 6"));
    }

    public static QuestionDataAccess getInstance() {
        if (questionDataAccess == null) {
            questionDataAccess = new QuestionDataAccess();
        }
        return questionDataAccess;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public void clearOptions() {
        for (Question question: questions) {
            question.setResponse("");
        }
    }
}
