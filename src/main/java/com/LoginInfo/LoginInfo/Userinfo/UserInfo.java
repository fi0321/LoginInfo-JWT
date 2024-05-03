package com.LoginInfo.LoginInfo.Userinfo;

import com.LoginInfo.LoginInfo.Logininfo.LoginInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserInfo {

  @Id
  @GeneratedValue
  private Integer id;

  private String firstName;

  private String lastName;

  @OneToOne(mappedBy = "userInfo")
  private LoginInfo loginInfo;



  public UserInfo() {}

  public UserInfo(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LoginInfo getLoginInfo() {
    return loginInfo;
  }

  public void setLoginInfo(LoginInfo loginInfo) {
    this.loginInfo = loginInfo;
  }


}
