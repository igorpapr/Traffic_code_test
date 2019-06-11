package ua.com.testing.entity;

import ua.com.testing.entity.question.Question;

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

    @Override
    public String toString() {
        return "Test{" +
                "questions=" + questions +
                '}';
    }
}
