package com.scp.user.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * 
 * @author youfeng.ma
 * @date 2017-09-22 10:31
 *
 */
public class JsonUtil {
  static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

  private static final ObjectMapper objectMapper;

  private JsonUtil() {
  }
  
  static {
    objectMapper = new ObjectMapper();
    // 去掉默认的时间戳格式
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    // 设置为中国上海时区
    objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    // 空值不序列化
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    // 反序列化时，属性不存在的兼容处理
    objectMapper.getDeserializationConfig()
        .withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    // 序列化时，日期的统一格式
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 单引号处理
    objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

  }

  /**
   * 将时间序列化成年月日格式
   *
   * @author xiansheng.cao
   * @date 2017/10/20
   * @version 5.6.0
   */
  public static void setDateFormat1() {
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
  }

  /**
   * 还原时间格式
   *
   * @author xiansheng.cao
   * @date 2017/10/20
   * @version 5.6.0
   */
  public static void setDateFormat2() {
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
  }

  public static <T> T toObject(String json, TypeReference<T> typeReference) {
    if (null == json || "".equals(json)) {
      logger.warn("toObject json is null or empty.");
      return null;
    }

    try {
      return objectMapper.readValue(json, typeReference);
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }
    return null;
  }

  /**
   * convert json string to object.
   * 
   * @param json json string
   * @param clazz object class
   * @return object
   */
  public static <T> T toObject(String json, Class<T> clazz) {
    if (null == json || "".equals(json)) {
      logger.warn("toObject json is null or empty.");
      return null;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("json=" + json);
    }

    try {
      return objectMapper.readValue(json, clazz);
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }
    return null;
  }

  /**
   * convert object to json string.
   * 
   * @param entity pbject
   * @return json string
   */
  public static <T> String toJson(T entity) {
    try {
      return objectMapper.writeValueAsString(entity);
    } catch (JsonGenerationException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }
    return null;
  }

  /**
   * convert json string to object.
   * 
   * @param json json string
   * @param typeReference object class
   * @return object
   */
  public static <T> T toCollection(String json, TypeReference<T> typeReference) {
    if (null == json || "".equals(json)) {
      logger.warn("toCollection json is null or empty.");
      return null;
    }

    try {
      return objectMapper.readValue(json, typeReference);
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }
    return null;
  }

  /**
   * json string convert to map.
   */
  public static <T> Map<String, Object> json2map(String jsonStr) {
    try {
      return objectMapper.readValue(jsonStr, Map.class);
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }

    return null;
  }

  /**
   * json string convert to map with javaBean.
   */
  public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
    Map<String, Map<String, Object>> map = null;
    try {
      map = objectMapper.readValue(jsonStr, new TypeReference<Map<String, T>>() {});
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }

    Map<String, T> result = new HashMap<>();
    if (map != null && !map.isEmpty()) {
      for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
        result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
      }
    }
    return result;
  }

  /**
   * json array string convert to list with javaBean.
   */
  public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
    List<Map<String, Object>> list = null;
    try {
      list = objectMapper.readValue(jsonArrayStr, new TypeReference<List<T>>() {});
    } catch (JsonParseException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (JsonMappingException exp) {
      logger.error(exp.getMessage(), exp);
    } catch (IOException exp) {
      logger.error(exp.getMessage(), exp);
    }

    List<T> result = new ArrayList<>();
    if (list != null && !list.isEmpty()) {
      for (Map<String, Object> map : list) {
        result.add(map2pojo(map, clazz));
      }
    }
    return result;
  }

  /**
   * map convert to javaBean.
   */
  public static <T> T map2pojo(Map map, Class<T> clazz) {
    return objectMapper.convertValue(map, clazz);
  }

}
