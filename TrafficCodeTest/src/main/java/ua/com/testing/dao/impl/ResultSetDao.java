package ua.com.testing.dao.impl;

import ua.com.testing.dao.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDao {
    private static final String FIND_ALL = "SELECT * FROM ";
    private Connector connector = new Connector();
    private String table;

    public ResultSetDao(String table) {
        this.table = table;
    }

    public ResultSet findAll() {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findWhereBaseId(long id) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement( FIND_ALL + table+" WHERE baseid=? ");

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
