package com.mohamedsamir1495.spring_app_without_spring_boot.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UnSubscribeDTO {
    String email;
    ArrayList<String>topics;
}
