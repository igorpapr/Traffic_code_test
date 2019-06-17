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

public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Test test = null;
        try {
            test = new TestDaoImpl().getAllQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int question;

        try {
            question = Integer.valueOf(req.getParameter("question"));
        } catch (Exception igonred) {
            resp.sendRedirect("/test?question=1");
            return;
        }

        try {
            if (question > test.getSize() || question < 1) {
                resp.sendRedirect("/test?question=1");
                return;
            }
        } catch (Exception ignored) {
            resp.sendRedirect("/test?question=1");
            return;
        }

        req.getSession().setAttribute("question",question);

        req.getSession().setAttribute("noOfTests",test.getSize());

        req.getSession().setAttribute("tests", test.getQuestions());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/test.jsp");
        requestDispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int question = Integer.valueOf(req.getParameter("question"));

        switch (action) {
            case "back":
                resp.sendRedirect("/test?question="+(question-1));
                break;
            case "next":
                resp.sendRedirect("/test?question="+(1+question));
                break;
            case "finish":
                //TODO: results
                break;
        }
    }
}
