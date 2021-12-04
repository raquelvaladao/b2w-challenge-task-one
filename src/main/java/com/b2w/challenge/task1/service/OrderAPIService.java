package com.b2w.challenge.task1.service;

import com.b2w.challenge.task1.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Service
public class OrderAPIService {


    public static final String BASE_URI = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9";

    public List<Product> jsonMapper() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(BASE_URI, String.class);

        assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));

        ObjectMapper mapper = new ObjectMapper();
        List<Product> mappedProductsList = Arrays.asList(
                mapper.readValue(response.getBody(), Product[].class)
        );
        return mappedProductsList;
    }

}
