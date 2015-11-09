package servlet_listener;

import database.EntityManager.UserEntityManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by V on 07.11.2015.
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserEntityManager.init();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        UserEntityManager.close();
    }
}
