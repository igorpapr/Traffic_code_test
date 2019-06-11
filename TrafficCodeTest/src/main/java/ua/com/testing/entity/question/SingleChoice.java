package ua.com.testing.entity.question;

public class SingleChoice extends Question {

    private byte rightAnswer;

    public SingleChoice(long id, String description, String[] questions, byte rightAnswer) {
        super(id, description, questions,Type.SINGLE);
        this.rightAnswer = rightAnswer;
    }

    public byte getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(byte rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
