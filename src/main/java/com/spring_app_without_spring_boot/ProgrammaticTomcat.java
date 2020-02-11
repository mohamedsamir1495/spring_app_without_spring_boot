package com.spring_app_without_spring_boot;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;


public class ProgrammaticTomcat {

    private Tomcat tomcat = null;

    private static boolean isFree(int port) {
        try {
            new ServerSocket(port).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void startTomcat(int selectedPort) throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(selectedPort);
        tomcat.setHostname("localhost");
        String appBase = ".";
        tomcat.getHost().setAppBase(appBase);

        File docBase = new File(System.getProperty("java.io.tmpdir"));
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        // add a servlet
        Class servletClass = MyServlet.class;
        Tomcat.addServlet(context, servletClass.getSimpleName(), servletClass.getName());
        context.addServletMappingDecoded("/home/", servletClass.getSimpleName());

        tomcat.start();
        tomcat
                .getServer()
                .await();
    }

    public void stopTomcat() throws LifecycleException {
        tomcat.stop();
        tomcat.destroy();
    }
}