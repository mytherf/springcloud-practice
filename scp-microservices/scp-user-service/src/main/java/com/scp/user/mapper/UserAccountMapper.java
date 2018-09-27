package com.scp.user.mapper;

import com.scp.user.model.UserAccount;
import com.scp.user.util.MyMapper;

public interface UserAccountMapper extends MyMapper<UserAccount> {

  void checkSqlCollation();
}