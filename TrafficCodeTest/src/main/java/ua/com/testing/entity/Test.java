package ua.com.testing.entity;

import ua.com.testing.entity.answer.Answer;
import ua.com.testing.entity.answer.ComplAnswer;
import ua.com.testing.entity.answer.MultiAnswer;
import ua.com.testing.entity.answer.SingleAnswer;
import ua.com.testing.entity.question.Compliance;
import ua.com.testing.entity.question.MultipleChoice;
import ua.com.testing.entity.question.Question;
import ua.com.testing.entity.question.SingleChoice;

import java.util.Arrays;
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

    private Byte[] toObjects(byte[] bytesPrim) {
        if(bytesPrim!=null) {
            Byte[] bytes = new Byte[bytesPrim.length];
            Arrays.setAll(bytes, n -> bytesPrim[n]);
            return bytes;
        }else {
            return null;
        }
    }

    public void setAnswer(int i, byte[] gettedAnswers) {
        answers[i] = new MultiAnswer(i, gettedAnswers);
    }

    public void setAnswer(int i, String[] gettedAnswers) {
        answers[i] = new ComplAnswer(i, gettedAnswers);
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public int getAllRightCount() {
        int count = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (answers[i] != null) {
                if (questions.get(i).getType() == Type.SINGLE) {
                    SingleChoice singleChoice = (SingleChoice) questions.get(i);
                    SingleAnswer singleAnswer = (SingleAnswer) answers[i];
                    if (singleChoice.getRightAnswer() == singleAnswer.getAnswer()) {
                        count++;
                    }
                } else if (questions.get(i).getType() == Type.MULTI) {
                    MultipleChoice multipleChoice = (MultipleChoice) questions.get(i);
                    MultiAnswer multiAnswer = (MultiAnswer) answers[i];
                    if (Arrays.equals(toObjects(multiAnswer.getAnswers()), multipleChoice.getRightAnswers())) {
                        count++;
                    }
                } else {
                    Compliance compliance = (Compliance) questions.get(i);
                    ComplAnswer complAnswer = (ComplAnswer) answers[i];
                    if (Arrays.equals(complAnswer.getAnswers(), compliance.getAnswers())) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Test{" + "questions=" + questions + '}';
    }
}
