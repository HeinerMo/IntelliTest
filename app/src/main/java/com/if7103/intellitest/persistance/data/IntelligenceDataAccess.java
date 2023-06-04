package com.if7103.intellitest.persistance.data;

import com.if7103.intellitest.domain.entity.Intelligence;
import com.if7103.intellitest.domain.entity.Question;
import com.if7103.intellitest.domain.entity.QuestionOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntelligenceDataAccess {

    private static IntelligenceDataAccess intelligenceDataAccess;
    private ArrayList<Intelligence> intelligences;

    private IntelligenceDataAccess() {
        intelligences = new ArrayList<>();
        intelligences.add(new Intelligence("Espacial", Arrays.asList(2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1)));
        intelligences.add(new Intelligence("Musical", Arrays.asList(2, 3, 2, 1, 3, 2, 1, 2, 2, 2, 2, 2)));
        intelligences.add(new Intelligence("Lingüístico-verbal", Arrays.asList(1, 3, 1, 3, 3, 3, 2, 2, 3, 2, 2, 2)));
        intelligences.add(new Intelligence("Lógico-matemático", Arrays.asList(2, 1, 2, 2, 3, 2, 2, 2, 3, 3, 2, 2)));
        intelligences.add(new Intelligence("Corporal-cinestésico", Arrays.asList(2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 2, 2)));
        intelligences.add(new Intelligence("Intrapersonal", Arrays.asList(1, 2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 3)));
        intelligences.add(new Intelligence("Interpersonal", Arrays.asList(2, 2, 2, 2, 3, 2, 1, 3, 2, 2, 2, 2)));
        intelligences.add(new Intelligence("Naturalista", Arrays.asList(3, 2, 2, 2, 1, 3, 2, 2, 2, 2, 2, 2)));
        intelligences.add(new Intelligence("Existencial", Arrays.asList(2, 2, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2)));
        intelligences.add(new Intelligence("Creativo", Arrays.asList(2, 2, 2, 2, 2, 1, 3, 2, 2, 2, 3, 2)));
        intelligences.add(new Intelligence("Emocional", Arrays.asList(3, 2, 2, 3, 2, 2, 2, 1, 3, 2, 2, 2)));
        intelligences.add(new Intelligence("Colaborativo", Arrays.asList(3, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 2)));
    }

    public static IntelligenceDataAccess getInstance() {
        intelligenceDataAccess = intelligenceDataAccess == null ? new IntelligenceDataAccess(): intelligenceDataAccess;
        return intelligenceDataAccess;
    }

    public ArrayList<Intelligence> getIntelligences() {
        return intelligences;
    }

    public void setIntelligences(ArrayList<Intelligence> intelligences) {
        this.intelligences = intelligences;
    }
}
