package com.lzj.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author  xcp
 * @version 1.0
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonProperty(value = "password")
    String password;
    @JsonProperty(value = "UID")
    String UID;
    @JsonProperty(value = "userName")
    String userName;
}
