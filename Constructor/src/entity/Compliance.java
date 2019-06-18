package entity;

import java.util.Arrays;

public class Compliance extends Question {

    private String[] answers;

    public Compliance(String description, String[] answers, String[] answers1) {
        super(description, answers);
        this.answers = answers1;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

    @Override
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "answers=" + Arrays.toString(answers) +
                '}' + super.toString();
    }
}
