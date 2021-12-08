package service.DAO;

import model.Blog;
import service.IBlogDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO {

    public BlogDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/final-exam?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void add(Blog blog) throws SQLException {

    }

    @Override
    public Blog findById(int id) {
        return null;
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from blog");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int categoryId = rs.getInt("categoryId");
                blogs.add(new Blog(id, title, content, categoryId));
            }
        } catch (SQLException e) {
        }
        return blogs;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog Blog) throws SQLException {
        return false;
    }
}
