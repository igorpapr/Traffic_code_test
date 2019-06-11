package ua.com.testing.entity;

public class MultipleChoice extends Question {

    private byte[] rightAnswers;

    public MultipleChoice(long id, String description, String[] questions, byte[] rightAnswers) {
        super(id, description, questions);
        this.rightAnswers = rightAnswers;
    }

    public byte[] getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(byte[] rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
}
