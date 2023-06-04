package com.if7103.intellitest.domain.entity;

import java.util.Arrays;

public class QuestionOption {
    private String option;
    private int value;

    public QuestionOption(String option, int value) {
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "QuestionOption{" +
                "option='" + option + '\'' +
                ", value=" + value +
                '}';
    }
}
