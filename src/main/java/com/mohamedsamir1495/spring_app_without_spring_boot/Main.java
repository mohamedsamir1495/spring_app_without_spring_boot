package com.mohamedsamir1495.spring_app_without_spring_boot;


import com.mohamedsamir1495.spring_app_without_spring_boot.config.SpringAppDispatcherServletInitializer;
import com.mohamedsamir1495.spring_app_without_spring_boot.server.CustomTomcat;

public class Main {

    public static void main(String[] args) throws Throwable {
        CustomTomcat customTomcat = new CustomTomcat();
        customTomcat.startServer(8080, new SpringAppDispatcherServletInitializer());
    }

}
