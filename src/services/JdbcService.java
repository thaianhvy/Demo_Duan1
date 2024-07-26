package services;

import java.util.List;

public interface JdbcService<T,ID> {
    List<T> findAll();
 }
