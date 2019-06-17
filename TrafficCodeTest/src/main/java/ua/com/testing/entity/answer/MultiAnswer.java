package ua.com.testing.entity.answer;

import ua.com.testing.entity.Type;

public class MultiAnswer extends Answer {
    byte[] answers;

    public MultiAnswer(int number, byte[] answers) {
        super(number, Type.MULTI);
        this.answers=answers;
    }

    public byte[] getAnswers() {
        return answers;
    }
}
