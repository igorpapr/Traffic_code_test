package ua.com.testing.entity.question;

import java.util.Arrays;

public class Compliance extends Question {

    private String[] answers;

    public Compliance(long id, String description, String[] questions, String[] answers) {
        super(id, description, questions,Type.COMPL);
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "answers=" + Arrays.toString(answers) +
                "} " + super.toString();
    }
}
