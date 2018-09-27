package com.scp.pay.util;


import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.sqlserver.InsertMapper;
import tk.mybatis.mapper.common.sqlserver.InsertSelectiveMapper;

/**
 * 继承自己的MyMapper
 */
public interface MyMapper<T> extends BaseSelectMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>,
    ExampleMapper<T>, RowBoundsMapper<T>, Marker, InsertMapper<T>, InsertSelectiveMapper<T>
     {
  // 特别注意，该接口不能被扫描到，否则会出错
}
