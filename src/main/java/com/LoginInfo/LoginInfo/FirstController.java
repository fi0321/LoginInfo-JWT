package com.LoginInfo.LoginInfo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class FirstController {
 private final LoginInfoRepository repository;



 public FirstController(LoginInfoRepository repository) {
  this.repository = repository;
 }



 @PostMapping("/LoginInfo")
 public LoginInfo post(@RequestBody LoginInfo loginInfo) {
  // TODO: process POST request
  return repository.save(loginInfo);

 }

 @GetMapping("/LoginInfo/{loginInfo-id}")
 public LoginInfo findLoginInfoById(@PathVariable("loginInfo-id") Integer id) {
  // TODO: process POST request
  return repository.findById(id).orElse(new LoginInfo());

 }

 @GetMapping("/LoginInfo")
 public List<LoginInfo> findAll() {
  // TODO: process POST request
  return repository.findAll();

 }

 @GetMapping("/LoginInfo/search/{username}")
 public List<LoginInfo> findLoginInfoById(@PathVariable("username") String username) {
  // TODO: process POST request
  return repository.findAllByUsername(username);

 }

 @DeleteMapping("/LoginInfo/{loginInfo-id}")
 @ResponseStatus(HttpStatus.OK)
 public void delete(@PathVariable("loginInfo-id") Integer id) {
  repository.deleteById(id);
 }

}
