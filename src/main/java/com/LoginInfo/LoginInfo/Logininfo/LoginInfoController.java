package com.LoginInfo.LoginInfo.Logininfo;

import java.util.List;


import com.LoginInfo.LoginInfo.Userinfo.UserInfo;
import com.LoginInfo.LoginInfo.Userinfo.UserInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LoginInfoController {
  private final LoginInfoRepository loginInfoRepository;
  private final UserInfoRepository userInfoRepository;



  public LoginInfoController(LoginInfoRepository loginInfoRepository,
      UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
    this.loginInfoRepository = loginInfoRepository;
  }



  @PostMapping("/LoginInfo")
  public LoginInfo post(@RequestBody LoginInfo loginInfo) {
    // TODO: process POST request
    return loginInfoRepository.save(loginInfo);

  }

  @PostMapping("/Login")
  public UserInfo post(@RequestBody LoginDto loginDto) {
    // TODO: process POST request
    var loginInfo = loginInfoRepository.findByUsername(loginDto.username());
    System.out.println(loginInfo);
    System.out.println(loginDto.password());
    System.out.println(loginInfo.getPassword());
    if (loginInfo != null && loginInfo.getPassword().equals(loginDto.password())) {
      System.out.println("checking");
      var userinfo = loginInfo.getUserInfo();
      userinfo.setLoginInfo(null);
      return userinfo;
    }
    return null;

  }



  @PostMapping("/CreateAccount")
  public UserInfo post(@RequestBody CreateAccountDto createAccountDto) {
    // TODO: process POST request
    var userinfo = new UserInfo(createAccountDto.firstName(), createAccountDto.lastName());
    var logininfo = new LoginInfo(createAccountDto.username(), createAccountDto.email(),
        createAccountDto.password());
    var savedUserInformation = userInfoRepository.save(userinfo);
    logininfo.setUserInfo(savedUserInformation);
    loginInfoRepository.save(logininfo);


    return savedUserInformation;


  }



  @GetMapping("/LoginInfo/{loginInfo-id}")
  public LoginInfo findLoginInfoById(@PathVariable("loginInfo-id") Integer id) {
    // TODO: process POST request
    return loginInfoRepository.findById(id).orElse(new LoginInfo());

  }

  @GetMapping("/LoginInfo")
  public List<LoginInfo> findAll() {
    // TODO: process POST request
    return loginInfoRepository.findAll();

  }

  @GetMapping("/LoginInfo/search/{username}")
  public LoginInfo findLoginInfoById(@PathVariable("username") String username) {
    // TODO: process POST request
    return loginInfoRepository.findByUsername(username);

  }

  @DeleteMapping("/LoginInfo/{loginInfo-id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("loginInfo-id") Integer id) {
    loginInfoRepository.deleteById(id);
  }

}
