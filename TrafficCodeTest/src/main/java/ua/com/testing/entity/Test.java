package ua.com.testing.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<Question> questions;

    public Test() {
        this.questions = new ArrayList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void add(Question question){
        questions.add(question);
    }
}
