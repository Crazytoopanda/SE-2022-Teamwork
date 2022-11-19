package com.lzj.demo.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class translateNumServiceImplTest {

    @Test
    void translateToword() {
        translateNumServiceImpl translateNumService = new translateNumServiceImpl();
        System.out.println(translateNumService.translateToword("1234"));
    }

    @Test
    void translateTonum() {
        translateNumServiceImpl translateNumService = new translateNumServiceImpl();
        System.out.println(translateNumService.translateTonum("一千二百三十四"));
    }

    @Test
    void translateTocap() {
        translateNumServiceImpl translateNumService = new translateNumServiceImpl();
        System.out.println(translateNumService.translateTocap("1555.1"));
    }

    @Test
    void translateTolow() {
        translateNumServiceImpl translateNumService = new translateNumServiceImpl();
        System.out.println(translateNumService.translateTolow("壹拾贰万叁仟玖佰捌拾柒元整"));
    }
}