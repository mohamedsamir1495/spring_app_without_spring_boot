package com.mohamedsamir1495.spring_app_without_spring_boot.service;

import com.mohamedsamir1495.spring_app_without_spring_boot.dto.PublishArticleDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.RegisterUserDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.SubscribeDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.UnSubscribeDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.model.EntityManager;
import com.mohamedsamir1495.spring_app_without_spring_boot.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    public User getUserByEmail(String email) {
        return EntityManager.INSTANCE.getUser(email);
    }

    public User registerUser(RegisterUserDTO registerUserDTO) {
        return EntityManager.INSTANCE.addUser(registerUserDTO);
    }

    public Boolean publishArticle(PublishArticleDTO publishArticleDTO) {
        return EntityManager.INSTANCE.publishArticle(publishArticleDTO);
    }

    public Boolean subscribeToTopics(SubscribeDTO subscribeDTO) {
        return EntityManager.INSTANCE.subscribeUserToTopics(subscribeDTO);
    }

    public boolean unSubscribeToTopics(UnSubscribeDTO unSubscribeDTO) {
        return EntityManager.INSTANCE.unSubscribeUserToTopics(unSubscribeDTO);
    }

    public ArrayList<String> getArticles(String email){
        return EntityManager.INSTANCE.getAllArticlesForUser(email);
    }
}
