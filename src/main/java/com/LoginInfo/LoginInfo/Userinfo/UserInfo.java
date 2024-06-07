package com.LoginInfo.LoginInfo.Userinfo;

import com.LoginInfo.LoginInfo.Logininfo.LoginInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;
  private String lastName;

  @OneToOne(mappedBy = "userInfo")
  @JsonBackReference
  private LoginInfo loginInfo;
}
