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


    public void insertSingle(String[] questions, byte rightAnswer) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMultiple(String[] questions, byte[] rightAnswers) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCompliance(String[] questions, String[] answers) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
