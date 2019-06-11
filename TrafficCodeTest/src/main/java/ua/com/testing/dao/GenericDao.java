package ua.com.testing.dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> findFiveRandom();
    List<T> findAll();
}
