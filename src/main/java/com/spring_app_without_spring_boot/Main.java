package com.spring_app_without_spring_boot;


public class Main {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        // Go to localHost:8080/home/ ==> To test the doGet Servlet
        ProgrammaticTomcat tomcat = new ProgrammaticTomcat();
        tomcat.startTomcat(PORT);
    }

}