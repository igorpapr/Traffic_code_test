package ua.com.testing.entity.question;

import ua.com.testing.entity.Type;

import java.util.Arrays;

public class MultipleChoice extends Question {

    private Byte[] rightAnswers;

    public MultipleChoice(long id, String description, String[] questions, Byte[] rightAnswers) {
        super(id, description, questions, Type.MULTI);
        this.rightAnswers = rightAnswers;
    }

    public Byte[] getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(Byte[] rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "rightAnswers=" + Arrays.toString(rightAnswers) +
                "} " + super.toString();
    }
}
