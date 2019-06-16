package ua.com.testing.dao.impl;

import ua.com.testing.dao.Connector;
import ua.com.testing.dao.GenericDao;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.question.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestDaoImpl {


    public Test getAllQuestions() throws SQLException {
        List<Question> questions= new ArrayList<>();


        List<Question> help = new SingleDaoImpl().mapResultSetToList();
        getFiveRandom(questions, help);

        help = new MultipleDaoImpl().mapResultSetToList();
        getFiveRandom(questions, help);

        help = new ComplDaoImpl().mapResultSetToList();
        getFiveRandom(questions, help);


        return new Test(questions);
    }

    private void getFiveRandom(List<Question> questions, List<Question> help) {
        for (int i = 0; i < help.size()-5; i++) {
            help.remove(ThreadLocalRandom.current().nextInt(0, help.size()+ 1));
        }
        questions.addAll(help);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new TestDaoImpl().getAllQuestions());
    }
}
