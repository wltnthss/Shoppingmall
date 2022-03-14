package com.shoppingmall;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lombok Test
 * @ 2022-03-15 손지수
 */

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public UserDto test(){
        UserDto userDto = new UserDto();
        userDto.setAge(28);
        userDto.setName("son");

        return userDto;
    }
}
