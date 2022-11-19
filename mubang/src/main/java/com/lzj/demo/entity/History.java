package com.lzj.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 林子键
 * @version 1.0
 */

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @JsonProperty(value = "UID")
    String UID;
    @JsonProperty(value = "input")
    String input;
    @JsonProperty(value = "output")
    String output;
    @JsonProperty(value = "date")
    String date;
}
