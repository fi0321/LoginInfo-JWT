package com.LoginInfo.LoginInfo.Score;

import com.LoginInfo.LoginInfo.Logininfo.LoginInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Score {

  @Id
  @GeneratedValue
  private Integer id;
  private int score;

  @ManyToOne
  @JoinColumn(name = "loginInfo_id")
  @JsonBackReference
  private LoginInfo loginInfo;

  public Score() {}
  public Score(int score) {
    this.score = score;
  }


  public LoginInfo getLoginInfo() {
    return loginInfo;
  }

  public void setLoginInfo(LoginInfo loginInfo) {
    this.loginInfo = loginInfo;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }



}
