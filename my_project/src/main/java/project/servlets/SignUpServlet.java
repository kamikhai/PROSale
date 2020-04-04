package project.servlets;

import org.springframework.context.ApplicationContext;
import project.models.User;
import project.services.AuthService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private AuthService authService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/template/signUp.ftl").forward(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext)context.getAttribute("springContext");
        authService = springContext.getBean(AuthService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = authService.signUp(User.builder()
                                .name(req.getParameter("name"))
                                .surname(req.getParameter("surname"))
                                .email(req.getParameter("email"))
                                .password(req.getParameter("password"))
                                .build());
        req.getSession().setAttribute("auth", true);
        req.getSession().setAttribute("v", false);
        resp.sendRedirect("/main");
    }
}
