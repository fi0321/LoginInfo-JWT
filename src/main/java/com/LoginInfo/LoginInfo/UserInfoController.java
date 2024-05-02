package com.LoginInfo.LoginInfo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

 private final UserInfoRepository userInfoRepository;


 public UserInfoController(UserInfoRepository userInfoRepository) {
  this.userInfoRepository = userInfoRepository;
 }


 @PostMapping("/userInfo")
 public UserInfo create(@RequestBody UserInfo userInfo) {
  return userInfoRepository.save(userInfo);
 }

 @GetMapping("/userInfo")
 public List<UserInfo> findAll() {
  return userInfoRepository.findAll();

 }
}
