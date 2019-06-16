package ua.com.testing.dao.impl;

import ua.com.testing.entity.question.Compliance;
import ua.com.testing.entity.question.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplDaoImpl {
    public List<Question> mapResultSetToList() throws SQLException {

        List<Question> result = new ArrayList<>();

        ResultSet baseResult = new ResultSetDao("questionbase").findByType((byte) 3);
        while (baseResult.next()) {


            long id = baseResult.getLong("id");
            String description = baseResult.getString("description");

            ResultSet singleResult = new ResultSetDao("compliance").findWhereBaseId(id);

            List<String> qst = new ArrayList<>();
            List<String> ans = new ArrayList<>();

            while (singleResult.next()) {
                qst.add(singleResult.getString("text"));

                ResultSet answerResult =
                        new ResultSetDao("answers").findById(singleResult.getLong("answerid"));
                answerResult.next();
                ans.add(answerResult.getString("text"));
            }

            String[] qsts = new String[qst.size()];
            qsts = qst.toArray(qsts);

            String[] answs = new String[ans.size()];
            answs = ans.toArray(answs);


            result.add(new Compliance(id, description, qsts, answs));
        }

        return result;
    }


    public static void main(String[] args) throws SQLException {
        List<Question> questions = new ComplDaoImpl().mapResultSetToList();

        System.out.println(questions);
    }
}
