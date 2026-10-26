package com.example.learnly.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WelcomePack {
    private static int created =0;
    private final int number = ++created;

    public WelcomePack() {
        System.out.println("Welcomepack #"+ number + " created");
    }
    public int number(){
        return  number;
    }
}
