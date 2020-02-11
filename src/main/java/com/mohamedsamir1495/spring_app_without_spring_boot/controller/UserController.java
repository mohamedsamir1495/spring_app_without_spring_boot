package com.mohamedsamir1495.spring_app_without_spring_boot.controller;

import com.mohamedsamir1495.spring_app_without_spring_boot.dto.PublishArticleDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.SubscribeDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.service.UserService;
import com.mohamedsamir1495.spring_app_without_spring_boot.dto.UnSubscribeDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser")
    public User getUser(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping(value = "/subscribe")
    public Boolean subscribeToTopics(@RequestBody SubscribeDTO subscribeDTO) {
        boolean res = userService.subscribeToTopics(subscribeDTO);
        return res;
    }

    @PostMapping(value = "/publish")
    public Boolean publishArticle(@RequestBody PublishArticleDTO publishArticleDTO) {
        boolean res = userService.publishArticle(publishArticleDTO);
        return res;
    }

    @PostMapping(value = "/unSubscribe")
    public Boolean unSubscribeToTopics(@RequestBody UnSubscribeDTO unSubscribeDTO) {
        boolean res = userService.unSubscribeToTopics(unSubscribeDTO);
        return res;
    }

    @GetMapping(value = "/getArticles")
    public ArrayList<String> getArticles(@RequestParam String email){
        return userService.getArticles(email);
    }
}
