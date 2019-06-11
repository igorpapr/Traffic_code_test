package ua.com.testing.entity.question;

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
}
