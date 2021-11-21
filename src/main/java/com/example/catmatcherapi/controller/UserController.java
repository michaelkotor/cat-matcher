package com.example.catmatcherapi.controller;

import com.example.catmatcherapi.model.User;
import com.example.catmatcherapi.model.dto.UserDto;
import com.example.catmatcherapi.service.CustomUserDetailsService;
import com.example.catmatcherapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
  private final UserService userService;

  @PostMapping("/register")
  public User register(@RequestBody UserDto userDto) {
    return userService.save(userDto);
  }

  @GetMapping("/login")
  public User login(UserDto userDto) {
    return userService.checkUser(userDto);
  }
}
