package com.example.blog.services;

import org.springframework.stereotype.Service;

@Service
public class StringTransformService {
    public String getFirstLetter(String word){
        return word.substring(0, 1);
    }

    public String getLastLetter(String word){
        if (word.length() > 3){
            return word.substring(word.length()-2, word.length()-1);
        } else {
            char  c = word.charAt(word.length()-1);
            return "" + c;
        }
    }

}
