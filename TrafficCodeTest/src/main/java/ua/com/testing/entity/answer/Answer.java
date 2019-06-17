package ua.com.testing.entity.answer;

import ua.com.testing.entity.Type;

public abstract class Answer {
    int number;
    Type type;

    public Answer(int number, Type type) {
        this.number = number;
        this.type = type;
    }


}
