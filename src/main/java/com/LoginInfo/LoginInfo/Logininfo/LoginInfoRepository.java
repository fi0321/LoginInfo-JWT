package com.LoginInfo.LoginInfo.Logininfo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {

  LoginInfo findByUsername(String username);

}
