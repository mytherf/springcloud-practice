package com.scp.user.service;

import com.scp.user.mapper.UserAccountMapper;
import com.scp.user.util.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends BaseService {

  @Autowired
  private UserAccountMapper userAccountMapper;

  
  /**
   * 模拟两个表连接，但是分别使用"Chinese_PRC_90_CI_AS" and "Chinese_PRC_CI_AS"排序规则
   * @author mytherf
   * @date 2018-09-27 43:16
   *
   */
  public void checkSqlCollation() {
    userAccountMapper.checkSqlCollation();
  }
}
