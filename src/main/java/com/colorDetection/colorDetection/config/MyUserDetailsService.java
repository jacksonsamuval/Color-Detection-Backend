package com.colorDetection.colorDetection.config;

import com.colorDetection.colorDetection.model.Users;
import com.colorDetection.colorDetection.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findUsersByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Not Found");
        }
        return new UserPrincipal(user);
    }
}
