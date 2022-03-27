package by.tms.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    void save(T t);
    void remove(T t);
    void update(T t);
    List<T> findAll();
}