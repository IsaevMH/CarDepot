package dao;

import java.util.List;

public interface RootDao<T> {
    T get(Long id);
    List<T> getAll();
    T update(Long id);
    T create(T teacher);
    T delete(Long id);
}