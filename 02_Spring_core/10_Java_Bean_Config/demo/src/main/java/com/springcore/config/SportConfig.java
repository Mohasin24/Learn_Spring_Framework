package com.springcore.config;

import com.springcore.common.Coach;
import com.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig
{
  @Bean
    public Coach swimCoach()
    {
        return new SwimCoach();
    }
}
