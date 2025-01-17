package com.LoginInfo.LoginInfo.Logininfo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Integer> {
 Optional<LoginInfo> findByUsername(String username);
}
