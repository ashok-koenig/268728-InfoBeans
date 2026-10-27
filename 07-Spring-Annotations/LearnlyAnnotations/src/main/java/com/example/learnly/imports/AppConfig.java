package com.example.learnly.imports;

import com.example.learnly.shared.SharedConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SharedConfig.class)
public class AppConfig {

}
