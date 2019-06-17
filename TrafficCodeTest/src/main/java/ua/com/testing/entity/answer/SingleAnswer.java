package ua.com.testing.entity.answer;

import ua.com.testing.entity.Type;

public class SingleAnswer extends Answer {
    byte answer;

    public SingleAnswer(int number,byte answer) {
        super(number, Type.SINGLE);
        this.answer = answer;
    }

    public byte getAnswer() {
        return answer;
    }
}
