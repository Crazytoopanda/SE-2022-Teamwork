package com.lzj.demo.entity;

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
    String UID;
    String input;
    String output;
    String date;
}
