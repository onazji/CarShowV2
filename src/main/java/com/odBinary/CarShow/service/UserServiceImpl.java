package com.odBinary.CarShow.service;

import com.odBinary.CarShow.entity.User;
import com.odBinary.CarShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if(user.isPresent()){
            User currentUser = user.get();
            builder =org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }



//    @Autowired
//    private UserServiceImpl userService;
//    @Override
//    public UserDetailsService loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = repository.findByUsername(username);
//        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
//        if(user.isPresent()){
//            User currentUser = user.get();
//            builder =org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(currentUser.getPassword());
//            builder.roles(currentUser.getRole());
//        } else {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return (UserDetailsService) builder.build();
//    }
}
