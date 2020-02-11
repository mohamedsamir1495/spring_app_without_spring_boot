package com.mohamedsamir1495.spring_app_without_spring_boot.service;

import com.mohamedsamir1495.spring_app_without_spring_boot.dto.PublishArticleDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.RegisterUserDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.SubscribeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class SeedDataBaseService {
    @Autowired
    UserService userService;

    @Bean
    public void seedDatabase(){
        userService.registerUser(new RegisterUserDTO("koko@koko.com","koko"));
        userService.subscribeToTopics(new SubscribeDTO("koko@koko.com",new ArrayList<String>(Arrays.asList("read","write","Essily"))));
        userService.publishArticle(new PublishArticleDTO("ya 7elm ba3eeeed",new ArrayList<String>(Arrays.asList("Essily"))));
    }
}
