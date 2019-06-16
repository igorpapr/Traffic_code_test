package ua.com.testing.entity;

import ua.com.testing.entity.question.Question;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<Question> questions;

    public Test(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getSize() {
        return questions.size();
    }

    @Override
    public String toString() {
        return "Test{" +
                "questions=" + questions +
                '}';
    }
}
