package com.LoginInfo.LoginInfo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {

 List<LoginInfo> findAllByUsername(String username);

}
