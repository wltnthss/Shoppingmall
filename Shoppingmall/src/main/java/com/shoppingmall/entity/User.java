package com.shoppingmall.entity;

import com.shoppingmall.constant.Role;
import com.shoppingmall.dto.UserFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setName(userFormDto.getName());
        user.setEmail(userFormDto.getEmail());
        user.setAddress(userFormDto.getAddress());
        String password = passwordEncoder.encode(userFormDto.getPassword());    // 비밀번호 암호화 설정
        user.setPassword(password);
        user.setRole(Role.USER);
        return user;
    }
}
