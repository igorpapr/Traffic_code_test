package ua.com.testing.entity.answer;

import ua.com.testing.entity.Type;

public class ComplAnswer extends Answer {
    String[] answers;

    public ComplAnswer(int number, String[] answers) {
        super(number, Type.COMPL);
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }
}
