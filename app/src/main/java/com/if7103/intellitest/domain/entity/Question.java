package com.if7103.intellitest.domain.entity;

public class Question {
    private String heading;
    private String[] options;
    private String response;
    public Question(String heading) {
        this.heading = heading;
        options = new String[]{"Mucho", "Poco", "Nada"};
        response = "";
    }

    public String getHeading() {
        return heading;
    }

    public String[] getOptions() {
        return options;
    }

    public void setResponse(String s) {
        response = s;
    }

    public boolean validResponse() {
        boolean valid = false;
        for (String s: options) {
            if (s.equals(response)) {
                valid = true;
            }
        }
        return valid;
    }
}
