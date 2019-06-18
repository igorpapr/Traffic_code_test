package entity;

import java.util.Arrays;

public class Compliance extends Question {

    private String[] rightAnswers;

    public Compliance(String description, String[] answers, String[] rightAnswers) {
        super(description, answers);
        this.rightAnswers = rightAnswers;
    }

    public String[] getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(String[] rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "answers=" + Arrays.toString(rightAnswers) +
                '}' + super.toString();
    }
}
