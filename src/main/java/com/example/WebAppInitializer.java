package com.example;

import org.springframework.web.WebApplicationInitializer;
import javax.servlet.ServletException;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.DispatcherServlet;

//import org.springframework.web.context.support.XmlWebApplicationContext;
import javax.servlet.ServletContext;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException{
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebMvcConfig.class);
        context.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("test", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}