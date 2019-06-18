package entity;

public class SingleChoice extends Question {

    private byte rightAnswer;

    public SingleChoice(String description, String[] answers, byte rightAnswer) {
        super(description, answers);
        this.rightAnswer = rightAnswer;
    }

    public byte getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(byte rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public String toString() {
        return "SingleChoice{" +
                "rightAnswer=" + rightAnswer +
                '}' + super.toString();
    }
}
