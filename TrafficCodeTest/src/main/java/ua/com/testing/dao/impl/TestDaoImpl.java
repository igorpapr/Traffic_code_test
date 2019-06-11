package ua.com.testing.dao.impl;

import ua.com.testing.dao.Connector;
import ua.com.testing.dao.GenericDao;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.question.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestDaoImpl extends GenericDaoImpl<Question> implements GenericDao<Question> {

    public TestDaoImpl() {
        super("questionbase", new Connector());
    }

    public Test getAllQuestions() throws SQLException {
        Test test = new Test();
        List<Question> single= new SingleDaoImpl().mapResultSetToEntity();

        for (int i = 0; i < single.size(); i++) {
            test.add(single.get(i));
        }

        return test;
    }



    @Override
    public Question mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        return null;
    }
}
