package com.LoginInfo.LoginInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class LoginInfo {
 @Id
 @GeneratedValue
 private Integer id;
 private String username;
 @Column(unique = true)
 private String email;
 private String password;
 @OneToMany(mappedBy = "loginInfo")
 @JsonManagedReference
 private List<Score> scores;


 @OneToOne(mappedBy = "loginInfo", cascade = CascadeType.ALL)
 private UserInfo userInfo;



 public LoginInfo() {}

 public LoginInfo(String username, String email, String password) {
  this.username = username;
  this.email = email;
  this.password = password;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public List<Score> getScores() {
  return scores;
 }

 public void setScores(List<Score> scores) {
  this.scores = scores;
 }

 public UserInfo getUserInfo() {
  return userInfo;
 }

 public void setUserInfo(UserInfo userInfo) {
  this.userInfo = userInfo;
 }
}
