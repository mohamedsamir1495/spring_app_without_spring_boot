package com.mohamedsamir1495.spring_app_without_spring_boot.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SubscribeDTO {
    String email;
    ArrayList<String> topics;

    public SubscribeDTO(String email, ArrayList<String> topics) {
        this.email=email;
        this.topics = topics;
    }
}
