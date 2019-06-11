package ua.com.testing.entity.question;

import java.util.Arrays;

public abstract class Question {

    private long id;
    private String description;
    private String[] questions;
    private Type type;

    protected Question(long id, String description, String[] questions, Type type) {
        this.id = id;
        this.description = description;
        this.questions = questions;
        this.type=type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", questions=" + Arrays.toString(questions) +
                ", type=" + type +
                '}';
    }
}
