package ua.com.testing.dao.impl;

import ua.com.testing.entity.question.MultipleChoice;
import ua.com.testing.entity.question.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MultipleDaoImpl {

    public List<Question> mapResultSetToList() throws SQLException {

        List<Question> result = new ArrayList<>();

        ResultSet baseResult = new ResultSetDao("questionbase").findByType((byte) 2);
        while (baseResult.next()) {


            long id = baseResult.getLong("id");
            String description = baseResult.getString("description");

            ResultSet singleResult = new ResultSetDao("multiple").findWhereBaseId(id);
            singleResult.next();


            List<String> qst = new ArrayList<>();

            qst.add(singleResult.getString("text"));

            StringTokenizer stringTokenizer =
                    new StringTokenizer(singleResult.getString("answers"), "_");

            Byte[] answers = answersParser(stringTokenizer);

            while (singleResult.next()) {
                qst.add(singleResult.getString("text"));
            }

            String[] qsts = new String[qst.size()];
            qsts = qst.toArray(qsts);


            result.add(new MultipleChoice(id, description, qsts, answers));
        }

        return result;
    }

    private Byte[] answersParser(StringTokenizer stringTokenizer) {
        List<Byte> listBytes;
        listBytes = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            listBytes.add(Byte.valueOf(stringTokenizer.nextToken()));
        }

        Byte[] answers = new Byte[listBytes.size()];
        answers = listBytes.toArray(answers);
        return answers;
    }

    public static void main(String[] args) throws SQLException {
        List<Question> questions = new MultipleDaoImpl().mapResultSetToList();

        System.out.println(questions);
    }

}
