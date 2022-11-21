package com.business.config;

import org.slf4j.Logger;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;

public class StartHelper {
    public static void printStartInfo(Logger logger, ConfigurableApplicationContext application) {
        try {
            ConfigurableEnvironment evn = application.getEnvironment();
            String applicationName = evn.getProperty("spring.application.name");
            String port = evn.getProperty("server.port");
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) application.getBean("tomcatServletWebServerFactory");
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            logger.info("\n--------------------------------------------------------------------\n\t"
                            + "Application '{}' is running! Access URLs:\n\t" +
                            "Local:\t\thttp://localhost:{}\n\t" +
                            "External:\thttp://{}:{}\n\t" +
                            "Doc: \t\thttp://{}:{}{}/doc.html\n" +
                            "-------------------------------------------------------------------\n",
                    applicationName,
                    port,
                    host,
                    port,
                    host,
                    port,
                    contextPath);
        } catch (Exception e) {

        }

    }
}
