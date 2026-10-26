package com.example.learnly.interfaces;

import com.example.learnly.model.Course;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    private final DiscountPolicy policy;

    public PricingService(DiscountPolicy policy) {
        this.policy = policy;
    }

    public String quote(Course course){
        return policy.name() + ": "+ course.title() + "cost INR "+ policy.apply(course.price());
    }
}
