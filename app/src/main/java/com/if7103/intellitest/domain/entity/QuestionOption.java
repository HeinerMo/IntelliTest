package com.if7103.intellitest.domain.entity;

import java.util.Arrays;

public class QuestionOption {
    private String option;
    private int[] values;

    public QuestionOption(String option, int[] values) {
        this.option = option;
        this.values = values;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "QuestionOption{" +
                "option='" + option + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
