package com.if7103.intellitest.domain.entity;

public class Question {
    private String heading;
    private QuestionOption[] options;
    private String response;

    private Intelligence intelligence;

    public Question(String heading) {
        this.heading = heading;
        response = "";
        this.options = new QuestionOption[3];
        options[0] = new QuestionOption("Mucho", 3);
        options[1] = new QuestionOption("Poco", 2);
        options[2] = new QuestionOption("Nada", 1);
    }

    public String getHeading() {
        return heading;
    }

    public void setResponse(String s) {
        response = s;
    }

    public QuestionOption[] getOptions() {
        return options;
    }

    public void setOptions(QuestionOption[] options) {
        this.options = options;
    }

    public boolean validResponse() {
        boolean valid = false;
        for (QuestionOption questionOption : options) {
            if (questionOption.getOption().equals(response)) {
                valid = true;
            }
        }
        return valid;
    }

    public QuestionOption getOption(String value) {
        for (QuestionOption option : options) {
            if (option.getOption().equals(value)) {
                return option;
            }
        }
        return null;
    }

    public void clearResponse() {
        this.response = "";
    }

    public String getResponse() {
        return response;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }
}
