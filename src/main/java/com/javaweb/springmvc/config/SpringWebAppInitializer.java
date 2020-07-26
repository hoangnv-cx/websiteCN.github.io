package com.javaweb.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
@Component
public class SpringWebAppInitializer implements WebApplicationInitializer {
	
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(SpringConfig.class);
        appContext.setServletContext(servletContext);
        
        DispatcherServlet dispatcherServlet=new DispatcherServlet(appContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
        		dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
       
        dispatcher.addMapping("/");
        CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter("UTF-8",true);
        servletContext.addFilter("encodingFilter", characterEncodingFilter)
        .addMappingForServletNames(null, false, "/*");
        
    }
 
}