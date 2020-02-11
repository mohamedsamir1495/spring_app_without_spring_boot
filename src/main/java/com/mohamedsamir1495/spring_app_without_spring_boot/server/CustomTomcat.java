package com.mohamedsamir1495.spring_app_without_spring_boot.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;


public class CustomTomcat {

    private Tomcat tomcat = null;

    public CustomTomcat() {
        tomcat = new Tomcat();
//      tomcat.setAddDefaultWebXmlToWebapp(false);
//      tomcat.noDefaultWebXmlPath();
    }

    private static boolean isFree(int port) {
        try {
            new ServerSocket(port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String createTomcatTempDir(int PORT) {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }

    public void startServer(int selectedPort , AbstractAnnotationConfigDispatcherServletInitializer dispatcherServletInitializer) throws LifecycleException {
        tomcat.setHostname("localhost");
        tomcat.setPort(selectedPort);
        Context ctx = tomcat.addContext("", createTomcatTempDir(selectedPort));

        ctx.addLifecycleListener((LifecycleEvent event) -> {
            if (event.getLifecycle().getState() == LifecycleState.STARTING_PREP) {
                try {
                    dispatcherServletInitializer.onStartup(ctx.getServletContext());
                } catch (Throwable e) {
//                    e.printStackTrace();
                }
            }
        });
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }

    public void stopServer() throws LifecycleException {
        tomcat.stop();
        tomcat.destroy();
    }

}