package ua.com.testing.dao.impl;

import ua.com.testing.dao.Connector;
import ua.com.testing.dao.GenericDao;
import ua.com.testing.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final String FIND_ALL = "SELECT * FROM ";

    protected final String table;
    protected final Connector connector;

    protected GenericDaoImpl(String table, Connector connector){
        this.table = table;
        this.connector = connector;
    }

    //get 3 * 5 of each type of question
    @Override
    public List<T> findAll() {
        try(Connection connection = connector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL + table);

            ResultSet resultSet = preparedStatement.executeQuery();

            return mapResultSetToRandomList(resultSet);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<T> mapResultSetToRandomList(ResultSet resultSet) throws SQLException{
        List<T> items = new ArrayList<>();
        List<T> selected = new ArrayList<>();

        while(resultSet.next()){
            items.add(mapResultSetToEntity(resultSet));
        }

        if(items.size() <= 5){
            return items;
        }

        Collections.shuffle(items);

        for (int i = 0; i < 5; i++){
            selected.add(items.get(i));
        }
        return selected;
    }

    public abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
