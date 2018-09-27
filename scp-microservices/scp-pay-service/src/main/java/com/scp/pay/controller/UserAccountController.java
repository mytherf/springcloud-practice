package com.scp.pay.controller;

import com.scp.pay.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户管理")
public class UserAccountController {

  @Autowired
  private UserAccountService userAccountService;

  @Value("${server.port}")
  String port;

  @RequestMapping(value="/hi", method = RequestMethod.GET)
  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  public String home(@RequestParam(value = "name", defaultValue = "forezp") String name,
      @RequestParam(value = "time", defaultValue = "1000") String time) {

    return userAccountService.hi(name, time, port);

  }
}
