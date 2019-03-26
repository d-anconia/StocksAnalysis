package com.stock.analysis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Configuration
public class StockAnalysisConfig {


    @Value("${data.api.connectTimeout}")
    String connectTimeout;

    @Value("${data.api.readTimeout}")
    String readTimeout;

    @Bean(name = "dataRestTemplate")
    public RestTemplate dataRestTemplate(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(Integer.valueOf(connectTimeout));
        restTemplateBuilder.setReadTimeout(Integer.valueOf(readTimeout));

        RestTemplate restTemplate = restTemplateBuilder.build();

        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;

    }
}
