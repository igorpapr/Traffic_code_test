package entity;

import java.util.Arrays;

public class MultipleChoice extends Question {

    private byte[] rightAnswers;

    public MultipleChoice(String description, String[] answers, byte[] rightAnswers) {
        super(description, answers);
        this.rightAnswers = rightAnswers;
    }

    public byte[] getRightAnswers() {
        return rightAnswers;
    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "rightAnswers=" + Arrays.toString(rightAnswers) +
                '}' + super.toString();
    }
}
