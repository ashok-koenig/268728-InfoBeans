package com.example.learnly.model;

import java.math.BigDecimal;

public record Course(long id, String title, Level level, BigDecimal price) {
}
