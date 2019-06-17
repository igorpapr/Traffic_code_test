package ua.com.testing.controller;

import ua.com.testing.entity.Test;
import ua.com.testing.entity.Type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = (Test) req.getSession().getAttribute("test");

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

        req.getSession().setAttribute("question", question);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/test.jsp");
        requestDispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int question = Integer.valueOf(req.getParameter("question"));

        switch (action) {
            case "back":
                getAnswers(req, resp);
                resp.sendRedirect("/test?question=" + (question - 1));
                break;
            case "next":
                getAnswers(req, resp);
                resp.sendRedirect("/test?question=" + (1 + question));
                break;
            case "finish":
                getAnswers(req, resp);

                //TODO: results
                break;
        }
    }

    private void getAnswers(HttpServletRequest req, HttpServletResponse resp) {
        int question = Integer.valueOf(req.getParameter("question"));

        Test test = (Test) req.getSession().getAttribute("test");

        if (test.getQuestions().get(question - 1).getType() == Type.SINGLE) {
            String answer = req.getParameter("answer");

            test.setAnswer(question-1, findSingleAnswer(answer, test.getQuestions().get(question).getQuestions()));
        } else if (test.getQuestions().get(question - 1).getType() == Type.MULTI) {
            String answers[] = req.getParameterValues("answer");

            test.setAnswer(question-1, findMultiAnswer(answers, test.getQuestions().get(question).getQuestions()));
        } else {
            String answers[] = req.getParameterValues("answer");

            test.setAnswer(question-1,answers);
        }

        req.getSession().setAttribute("answers", test.getAnswers());
    }

    private byte findSingleAnswer(String answer, String[] answers) {
        for (byte i = 1; i <= answers.length; i = (byte) (i + 1)) {
            if (answers[i - 1].equals(answer)) {
                return i;
            }
        }
        return 0;
    }

    private byte[] findMultiAnswer(String[] my, String[] answers) {
        try {
            byte[] right = new byte[my.length];
            for (byte j = 0; j <my.length; j++) {
                for (byte i = 1; i <= answers.length; i = (byte) (i + 1)) {
                    if (answers[i - 1].equals(my[j])) {
                        right[j]=i;
                    }
                }
            }
            return right;
        }catch (Exception ignored){
            return null;
        }
    }


}
