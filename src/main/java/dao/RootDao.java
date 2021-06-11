package dao;

import java.util.List;

public interface RootDao<T> {
    T get(Long id);
    List<T> getAll();
    void update(T driver);
    void create(T driver);
    void delete(Long id);
}