package com.onward.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.onward.app.security.AuthRequest;
import com.onward.app.security.JwtService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
//TODO once this runs on server must be authenticated to create users
public class UserController {

    @Autowired
    private UserInfoService service;
    
    @Autowired
    private JwtService jwtService;
 
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/addnewuser") 
    public String addNewUser(@RequestBody UserInfo userInfo) { 
        return service.addUser(userInfo); 
    }
    
    @GetMapping("/addnewuser")
    public List<UserInfo> getUserInfos() {
        return service.getAllUsers();
    }

    /* 
    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }
    */

    @PostMapping(path = "/login", consumes = "application/json") 
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        if (authentication.isAuthenticated()) { 
            return jwtService.generateToken(authRequest.getUsername()); 
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    
     }
 }
 
