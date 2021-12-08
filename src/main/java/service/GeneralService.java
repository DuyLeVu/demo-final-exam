package service;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {

        public void add(T t) throws SQLException;

        public T findById(int id);

        public List<T> findAll();

        public boolean delete(int id) throws SQLException;

        public boolean update(T t) throws SQLException;
    }

