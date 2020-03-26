package project.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("auth", req.getSession().getAttribute("auth"));
        req.setAttribute("v", req.getSession().getAttribute("v"));
        req.getRequestDispatcher("/template/main.ftl").forward(req,resp);
    }
}
