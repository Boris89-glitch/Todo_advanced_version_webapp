package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"api/*"})
public class HelloServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private static final String NAME_PARAM = "name";

    //konstruktor
    private HelloService service;
    HelloServlet(HelloService service) {
        this.service = service;
    }

    @SuppressWarnings("Unused")
    public HelloServlet(){
        this(new HelloService());
    }

    //Servlet get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Request received with params: "+ req.getParameterMap());
        var name = req.getParameter(NAME_PARAM);
        var greet = service.prepareGreeting(name);
        var world = Optional.ofNullable(name).orElse("World");
        resp.getWriter().write(greet);
    }
}
