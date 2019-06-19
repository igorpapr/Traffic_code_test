package entity;

import java.util.Arrays;

public abstract class Question {

    private String description;
    private String[] answers;

    protected Question(String description, String[] answers) {
        this.description = description;
        this.answers = answers;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "description='" + description + '\'' +
                ", answers=" + Arrays.toString(answers) +
                '}';
    }
}
