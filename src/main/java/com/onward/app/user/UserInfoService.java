package com.onward.app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;
    
    @Autowired 
    PasswordEncoder encoder;
  
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
  
        Optional<UserInfo> userDetail = repository.findByUsername(username); 
  
        // Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
    } 
  
    public String addUser(UserInfo userInfo) { 
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        // userInfo.isEnabled(true);
        repository.save(userInfo); 
        return "User Added Successfully"; 
    }
    
    public List<UserInfo> getAllUsers() {
        return (List<UserInfo>) repository.findAll();
    }

}
