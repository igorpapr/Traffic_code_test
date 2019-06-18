package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseDao {

    private final Connector connector;

    public DataBaseDao(Connector connector) {
        this.connector = connector;
    }

    public void insertSingle(String description, String[] questions, byte rightAnswer) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT questionbase(description,type) VALUES(?,?)");

            byte type = 1;
            preparedStatement.setString(1, description);
            preparedStatement.setByte(2, type);
            preparedStatement.executeUpdate();

            long id = getLastId(description);


            for (String question : questions) {

                preparedStatement = connection.prepareStatement("INSERT single(baseid,text,answer) VALUES(?,?,?)");

                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, question);
                preparedStatement.setByte(3, rightAnswer);

                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMultiple(String description, String[] questions, byte[] rightAnswers) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT questionbase(description,type) VALUES(?,?)");

            byte type = 2;
            preparedStatement.setString(1, description);
            preparedStatement.setByte(2, type);
            preparedStatement.executeUpdate();

            long id = getLastId(description);
            String answers = "";

            for (int i = 0; i < rightAnswers.length; i++) {
                answers += String.valueOf(rightAnswers[i]) +( i < rightAnswers.length - 1 ? "_" : "");
            }

            for (String question : questions) {

                preparedStatement =
                        connection.prepareStatement("INSERT multiple(baseid,text,answers) VALUES(?,?,?)");

                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, question);
                preparedStatement.setString(3, answers);

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCompliance(String description, String[] questions, String[] answers) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT questionbase(description,type) VALUES(?,?)");

            byte type = 3;
            preparedStatement.setString(1, description);
            preparedStatement.setByte(2, type);
            preparedStatement.executeUpdate();

            long id = getLastId(description);

            long[] ids = new long[answers.length];

            for (int i = 0; i < answers.length; i++) {
                preparedStatement = connection.prepareStatement("INSERT answers(text) VALUES(?)");

                preparedStatement.setString(1, answers[i]);

                preparedStatement.executeUpdate();

                ids[i] = getLastId2(answers[i]);
            }

            for (int i = 0; i < answers.length; i++) {

                preparedStatement =
                        connection.prepareStatement("INSERT compliance(baseid,text,answerid) VALUES(?,?,?)");

                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, questions[i]);
                preparedStatement.setLong(3, ids[i]);

                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private long getLastId(String description) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM questionbase WHERE description=?");

            preparedStatement.setString(1, description);

            ResultSet resultSet = preparedStatement.executeQuery();

            long id=-1L;

            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }

            return id;




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Long.parseLong(null);
    }

    private long getLastId2(String description) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM answers WHERE text=?");

            preparedStatement.setString(1, description);

            ResultSet resultSet = preparedStatement.executeQuery();

            long id = -1;

            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }

            return id;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Long.parseLong(null);
    }
}
