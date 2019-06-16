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
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);


            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findByType(byte type) {
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table + " WHERE type=?");

            preparedStatement.setByte(1, type);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findWhereBaseId(long id) {
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table + " WHERE baseid=? ");

            preparedStatement.setLong(1, id);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet findById(long id) {
        Connection connection = connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table + " WHERE id=? ");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
