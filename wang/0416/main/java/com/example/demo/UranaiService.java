package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UranaiService  {

    @Autowired
    private UranaiRepository repository;

    public String getResult(String question) {
        Random r = new Random();
        int a = question.length();
     	int b = r.nextInt(10);
     	int questionId = (a*b)%10;


        return repository.getResult(questionId);
    }
}
