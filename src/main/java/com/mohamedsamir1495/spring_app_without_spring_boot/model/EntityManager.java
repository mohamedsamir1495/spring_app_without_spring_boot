package com.mohamedsamir1495.spring_app_without_spring_boot.model;

import com.mohamedsamir1495.spring_app_without_spring_boot.dto.PublishArticleDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.RegisterUserDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.SubscribeDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.UnSubscribeDTO;

import java.util.*;

public enum  EntityManager {
    INSTANCE;
    private List<User> users = new ArrayList<User>();
    private Map<String, Set<String>> topics = new HashMap<>();

    public User addUser(RegisterUserDTO registerUserDTO) {
        User addedUser = new User(registerUserDTO.getEmail(),registerUserDTO.getName(),new ArrayList<String>());
        users.add(addedUser);
        return addedUser;
    }

    public ArrayList<String> getAllArticlesForUser(String userEmail){
        Set<String> response = new HashSet<>();
        User storedUser = getUser(userEmail);

        if(storedUser == null)
            return new ArrayList<String>();

        topics.forEach((topic,Articles) -> {
            if(storedUser.getSubscribedTopics().indexOf(topic)>-1){
                response.addAll(Articles);
            }
        });
        return new ArrayList<>(response);
    }
    public Boolean publishArticle(PublishArticleDTO publishArticleDTO) {
        for(String topic : publishArticleDTO.getTopics()){
            if(topics.get(topic)!=null)
            topics.get(topic).add(publishArticleDTO.getArticleAsText());
            else
                topics.put(topic,new HashSet<>(Arrays.asList(publishArticleDTO.getArticleAsText())));
        }
        return true;
    }

    public User getUser(String email) {
        User storedUser = users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        return storedUser;
    }

    public Boolean subscribeUserToTopics(SubscribeDTO subscribeDTO) {
        User storedUser = getUser(subscribeDTO.getEmail());
        if(storedUser == null)
            return false;
        else
            storedUser.getSubscribedTopics().addAll(subscribeDTO.getTopics());

        return true;
    }

    public boolean unSubscribeUserToTopics(UnSubscribeDTO unSubscribeDTO) {
        User storedUser = getUser(unSubscribeDTO.getEmail());
        if(storedUser == null)
            return false;
        else
            storedUser.getSubscribedTopics().removeAll(unSubscribeDTO.getTopics());

        return true;
    }
}
