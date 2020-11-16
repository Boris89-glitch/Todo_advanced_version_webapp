package io.github.mat3e.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"api"})
public class HelloServlet extends HttpServlet {

    private static final String LANG_PARAM = "io/github/mat3e/lang";
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
        var lang = req.getParameter(LANG_PARAM);
        Integer langId = null;
        //get langId if there is one
        try {
            langId = Integer.valueOf(lang);
        } catch (NumberFormatException e){
            logger.warn("Non-numeric lang id" + lang);
        }
        resp.getWriter().write(service.prepareGreeting(name, langId));
    }
}
