package com.scp.user.controller;

import com.scp.user.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

  @Autowired
  private UserAccountService userAccountService;

  @Value("${server.port}")
  String port;

  @RequestMapping("/hi")
  public String home(@RequestParam(value = "name", defaultValue = "forezp") String name,
      @RequestParam(value = "time", defaultValue = "1000") String time) {

    return userAccountService.hi(name, time, port);

  }
}
