package com.example.bookingservice.integration.config;


import com.example.bookingservice.integration.decoder.FeignErrorDecoder;
import com.example.bookingservice.integration.interceptor.FeignClientInterceptor;
import feign.Client;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class FeignClientConfiguration {

    @Bean
    public Client client() {
        return new FeignClientInterceptor(null,null);
    }

    @Bean
    public Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

   @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecoder();
    }

}
