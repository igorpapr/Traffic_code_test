package ua.com.testing.controller;

import ua.com.testing.dao.impl.TestDaoImpl;
import ua.com.testing.entity.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = null;
        try {
            test = new TestDaoImpl().getAllQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("test", test);

        req.getSession().setAttribute("noOfTests", test.getSize());

        req.getSession().setAttribute("tests", test.getQuestions());

        resp.sendRedirect("/test?question=1");
    }
}
