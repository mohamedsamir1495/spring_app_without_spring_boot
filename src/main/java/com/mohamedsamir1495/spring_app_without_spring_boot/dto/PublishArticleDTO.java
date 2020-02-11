package com.mohamedsamir1495.spring_app_without_spring_boot.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PublishArticleDTO {
    String articleAsText;
    ArrayList<String> topics;

    public PublishArticleDTO(String articleAsText, ArrayList<String> topics) {
        this.articleAsText = articleAsText;
        this.topics = topics;
    }
}
