package ua.com.testing.entity;

import ua.com.testing.entity.answer.Answer;
import ua.com.testing.entity.answer.ComplAnswer;
import ua.com.testing.entity.answer.MultiAnswer;
import ua.com.testing.entity.answer.SingleAnswer;
import ua.com.testing.entity.question.Question;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<Question> questions;

    private Answer[] answers;

    public Test(List<Question> questions) {
        this.questions = questions;
        answers = new Answer[questions.size()];
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getSize() {
        return questions.size();
    }

    public void setAnswer(int i, byte answer) {
        answers[i] = new SingleAnswer(i, answer);
    }

    public void setAnswer(int i, byte[] gettedAnswers) {
        answers[i] = new MultiAnswer(i, gettedAnswers);
    }

    public void setAnswer(int i, String[] gettedAnswers) {
        answers[i]=new ComplAnswer(i,gettedAnswers);
    }

    public Answer[] getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Test{" +
                "questions=" + questions +
                '}';
    }
}
