package com.onward.app.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor; 
  
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo { 
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore 
    private int id; 
    private String username; 
    private String email; 
    private String password; 
    private String roles; 
  
} 
