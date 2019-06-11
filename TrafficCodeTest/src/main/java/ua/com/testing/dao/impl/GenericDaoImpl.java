package ua.com.testing.dao.impl;

import ua.com.testing.dao.Connector;
import ua.com.testing.dao.GenericDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final String FIND_ALL = "SELECT * FROM ";

    protected final String table;
    protected final Connector connector;

    protected GenericDaoImpl(String table, Connector connector) {
        this.table = table;
        this.connector = connector;
    }

    //get 3 * 5 of each type of question
    @Override
    public List<T> findFiveRandom() {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToRandomList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<T> mapResultSetToRandomList(ResultSet resultSet) throws SQLException {
        List<T> items = mapResultSetToList(resultSet);
        List<T> selected = new ArrayList<>();


        if (items.size() <= 5) {
            return items;
        }
        Random random = new Random();
        int itemsSize = items.size();

        while (selected.size() < 5) {
            int randomIndex = random.nextInt(itemsSize);
            T element = items.get(randomIndex);

            if (!selected.contains(element)) {
                selected.add(element);
            }
        }
        return selected;
    }

    public List<T> mapResultSetToList(ResultSet resultSet) throws SQLException
    {
        List<T> result = new ArrayList<>();

        while (resultSet.next()){
            result.add(mapResultSetToEntity(resultSet));
        }

        return result;
    }

    public abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
