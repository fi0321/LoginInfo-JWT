package com.LoginInfo.LoginInfo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
 private final ScoreRepository scoreRepository;

 public ScoreController(ScoreRepository scoreRepository) {
  this.scoreRepository = scoreRepository;
 }

 @PostMapping("/scores")
 public Score create(@RequestBody ScoreDto dto) {
  var score = toScore(dto);
  return scoreRepository.save(score);
 }

 private Score toScore(ScoreDto dto) {
  var score = new Score();
  score.setScore(dto.score());

  var loginInfo = new LoginInfo();
  loginInfo.setId(dto.loginInfoId());
  score.setLoginInfo(loginInfo);
  return score;
 }

 @GetMapping("/scores")
 public List<Score> findAll() {
  return scoreRepository.findAll();
 }


}
