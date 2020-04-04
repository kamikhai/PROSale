package project.servlets;

import org.springframework.context.ApplicationContext;
import project.services.TokenService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerificationServlet extends HttpServlet {
    private TokenService tokenService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        tokenService = springContext.getBean(TokenService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getParameter("t");
        Long userId = tokenService.getUser(token);
        String answer = "";
        if (userId != null){
            req.getSession().setAttribute("v", true);
            answer = "Почта успешно подтверждена! Войдите в свой аккаунт";
        } else {
            answer = "Неверная ссылка или истек срок использования";
        }
        req.setAttribute("answer", answer);
        req.getRequestDispatcher("/template/verification.ftl").forward(req,resp);
    }
}
