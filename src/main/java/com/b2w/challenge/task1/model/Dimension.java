package com.b2w.challenge.task1.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dimension implements Serializable {

    @JsonProperty(value="weight")
    private Double weight;

    @JsonProperty(value="height")
    private Double height;

    @JsonProperty(value="width")
    private Double  width;

    @JsonProperty(value="length")
    private Double length;

}
