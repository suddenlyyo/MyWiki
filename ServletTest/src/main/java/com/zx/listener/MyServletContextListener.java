package com.zx.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-06 15:57 <br>
 * </p>
 *
 * @author zhou  xun
 */
@WebListener()
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener init.........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener destory..........");
    }
}
