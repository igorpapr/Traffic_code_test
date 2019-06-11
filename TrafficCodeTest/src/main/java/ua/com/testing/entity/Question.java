package ua.com.testing.entity;

public abstract class Question {

    private long id;
    private String description;
    private String[] questions;

    protected Question(long id, String description, String[] questions) {
        this.id = id;
        this.description = description;
        this.questions = questions;
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

}
