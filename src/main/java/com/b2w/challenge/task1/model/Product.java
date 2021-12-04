package com.b2w.challenge.task1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    @JsonProperty(value="name")
    private String name;

    @JsonProperty(value="code")
    private Long code;

    @JsonProperty(value="date")
    private Date date;

    @JsonProperty(value="dimension")
    private Dimension dimension;

}
