package ua.com.testing.dao.impl;

import ua.com.testing.entity.question.Question;
import ua.com.testing.entity.question.SingleChoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingleDaoImpl {

    public List<Question> mapResultSetToEntity() throws SQLException {

        List<Question> result = new ArrayList<>();

        ResultSet baseResult = new ResultSetDao("questionbase").findAll();
        while (baseResult.next()) {


            long id = baseResult.getLong("id");
            String description = baseResult.getString("description");

            ResultSet singleResult = new ResultSetDao("single").findWhereBaseId(id);

            List<String> qst = new ArrayList<>();

            singleResult.next();

            byte answer = singleResult.getByte("answer");
            qst.add(singleResult.getString("text"));
            while (singleResult.next()) {
                qst.add(singleResult.getString("text"));
            }

            String[] qsts = new String[qst.size()];
            qsts = qst.toArray(qsts);


            result.add(new SingleChoice(id, description, qsts, answer));
        }

        return result;
    }
}
