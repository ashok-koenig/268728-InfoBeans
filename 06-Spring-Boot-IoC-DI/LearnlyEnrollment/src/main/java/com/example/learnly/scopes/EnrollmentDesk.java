package com.example.learnly.scopes;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentDesk {
    private final ObjectProvider<WelcomePack> pack;

    public EnrollmentDesk(ObjectProvider<WelcomePack> pack) {
        this.pack = pack;
    }

    public String issue(){
        return "Issued welcome pack #" + pack.getObject().number();
    }
}
