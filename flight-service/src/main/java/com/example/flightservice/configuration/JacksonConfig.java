package com.example.flightservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class JacksonConfig {

    private static final String PATTERN = "dd-MM-yyyy HH:mm";
    private static final TimeZone TZ = TimeZone.getTimeZone("Europe/Istanbul");

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        DateFormat df = new SimpleDateFormat(PATTERN);
        df.setTimeZone(TZ);
        mapper.setDateFormat(df);
        mapper.setTimeZone(TZ);
        return mapper;
    }
}