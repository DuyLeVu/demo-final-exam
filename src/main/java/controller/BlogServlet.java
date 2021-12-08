package controller;

import model.Blog;
import model.Category;
import service.CategoryService;
import service.DAO.BlogDAO;
import service.DAO.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BlogServlet", urlPatterns = "/blogs")
public class BlogServlet extends HttpServlet {
    BlogDAO blogDAO = new BlogDAO();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default: showList(request, response);
            break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/list.jsp");
        List<Blog> blogs = blogDAO.findAll();
        List<Category> categories = findAllCategory(blogs);
        request.setAttribute("blogs", blogs);
        request.setAttribute("categories", categories);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Category> findAllCategory(List<Blog> blogs){
        List<Category> list = new ArrayList<>();
        for (int i=0; i<= blogs.size();i++){
            Category category = categoryService.findById(blogs.get(i).getCategoryId());
            list.add(category);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
