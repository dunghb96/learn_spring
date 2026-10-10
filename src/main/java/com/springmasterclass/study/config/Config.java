package com.springmasterclass.study.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springmasterclass.study.dto.request.UserRq;
import com.springmasterclass.study.entity.User;

@Configuration
public class Config {

     @Bean
     public ModelMapper modelMapper() {
          ModelMapper modelMapper = new ModelMapper();

          modelMapper.getConfiguration()
               .setFieldMatchingEnabled(true)
               .setMatchingStrategy(MatchingStrategies.STRICT);

          modelMapper.typeMap(User.class, UserRq.class).addMappings(mapper -> {
               mapper.map(User::getName, UserRq::setName);
          });

          return modelMapper;
     }
}
