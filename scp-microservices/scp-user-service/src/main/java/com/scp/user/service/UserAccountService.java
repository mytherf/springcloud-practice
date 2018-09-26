package com.scp.user.service;

import com.scp.user.mapper.UserRegStatMapper;
import com.scp.user.model.UserRegStat;
import com.scp.user.util.BaseService;
import com.scp.user.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends BaseService {

  @Autowired
  private UserRegStatMapper userRegStatMapper;

  public String hi(String name, String time, String port) {
    
    try {
      Thread.sleep(Integer.valueOf(time));
      UserRegStat user = new UserRegStat();
      user.setId(31);
      UserRegStat entity = userRegStatMapper.selectOne(user);
      logger.info("result={}", JsonUtil.toJson(entity));
      
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return "hi " + name + " ,i am from port:" + port + time;
  }
}
