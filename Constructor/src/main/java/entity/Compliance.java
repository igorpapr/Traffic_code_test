package entity;

import java.util.Arrays;

public class Compliance extends Question {

    private String[] rightAnswers; //right side of answers

    public Compliance(String description, String[] answers, String[] rightAnswers) {
        super(description, answers);
        this.rightAnswers = rightAnswers;
    }

    public String[] getRightAnswers() {
        return rightAnswers;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "answers=" + Arrays.toString(rightAnswers) +
                '}' + super.toString();
    }
}
