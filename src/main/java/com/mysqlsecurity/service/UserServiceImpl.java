package com.mysqlsecurity.service;

import com.mysqlsecurity.model.CustomUserDetails;
import com.mysqlsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByUsername(username)
               .map(CustomUserDetails::new)
               .orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
    }
}
