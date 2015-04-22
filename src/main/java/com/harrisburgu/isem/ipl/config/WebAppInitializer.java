package com.harrisburgu.isem.ipl.config;

import org.springframework.context.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by bharatkosti on 4/21/15.
 */
public class WebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    // Create the 'root' Spring application context
       AnnotationConfigWebApplicationContext rootContext =
            new AnnotationConfigWebApplicationContext();
          rootContext.register(ApplicationContext.class);

          // Manage the lifecycle of the root application context
          servletContext.addListener(new ContextLoaderListener(rootContext));

          // Create the dispatcher servlet's Spring application context
          AnnotationConfigWebApplicationContext dispatcherContext =
            new AnnotationConfigWebApplicationContext();
          dispatcherContext.register(MvcContext.class);

          // Register and map the dispatcher servlet
          ServletRegistration.Dynamic dispatcher =
              servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
          dispatcher.setLoadOnStartup(1);
          dispatcher.addMapping("/");



  }
}
