package com.shoppingmall.service;

import com.shoppingmall.dto.UserFormDto;
import com.shoppingmall.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setEmail("Test@email.com");
        userFormDto.setName("노루");
        userFormDto.setAddress("서울시 송파구");
        userFormDto.setPassword("1234");
        return User.createUser(userFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입테스트")
    public void saveUserTest(){
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getAddress(), savedUser.getAddress());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getRole(), savedUser.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void 중복가입테스트입니다(){
        User user1 = createUser();
        User user2 = createUser();
        userService.saveUser(user1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            userService.saveUser(user2);
        });

        assertEquals("이미 가입된 회원", e.getMessage());
    }
}

