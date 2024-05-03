package com.LoginInfo.LoginInfo.Logininfo;

import java.util.ArrayList;
import java.util.List;

import com.LoginInfo.LoginInfo.Userinfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity

public class LoginInfo {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(unique = true)
  private String username;
  @Column(unique = true)
  private String email;
  private String password;



  @OneToOne
  @JoinColumn(name = "userInfo_id")
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



  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }


}
