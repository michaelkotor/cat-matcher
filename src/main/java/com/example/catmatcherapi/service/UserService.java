package com.example.catmatcherapi.service;

import com.example.catmatcherapi.model.User;
import com.example.catmatcherapi.model.dto.UserDto;
import com.example.catmatcherapi.reposity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User checkUser(UserDto userDto) {
    User toCheck = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException(
            "No user with username: " + userDto.getUsername()));
    if(passwordEncoder.matches(userDto.getPassword(), toCheck.getPassword())) {
      return toCheck;
    }
    throw new RuntimeException("Incorrect password");
  }

  public User save(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    String securePassword = passwordEncoder.encode(userDto.getPassword());
    user.setPassword(securePassword);
    return userRepository.save(user);
  }

  public User getCurrentUser() {
    return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
