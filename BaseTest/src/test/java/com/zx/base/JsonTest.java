package com.zx.base;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.github.jsonzou.jmockdata.JMockData;
import com.zx.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * json 测试
 */
public class JsonTest {
    @Test
    public void jsonTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("first", "first value");
        if (jsonObject.containsKey("first")) {
            jsonObject.getString("first");
        }
    }

    @Test
    @DisplayName("Java对象–>JSON字符串")
    public void jsonTest1() {
        User user = JMockData.mock(User.class);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", user.getName());
//        System.out.println(jsonObject.toJSONString());

        String jsonString = JSONObject.toJSONString(user);
        System.out.println(jsonString);
    }

    @Test
    @DisplayName("Java对象–>JSON对象")
    public void jsonTest2() {
        User user = JMockData.mock(User.class);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(user);
        System.out.println(jsonObject);
    }

    @Test
    @DisplayName("JSON对象–>Java对象")
    public void jsonTes3() {
        User user = JMockData.mock(User.class);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(user);
        //JSON对象转换成Java对象
        //fastjson1写法
        //User user1 = JSONObject.toJavaObject(jsonObject, User.class);
        User user1 = jsonObject.to(com.alibaba.fastjson2.TypeReference.get(User.class));
        System.out.println(user1);
    }

    @Test
    @DisplayName("JSON字符串–>JSON对象")
    public void jsonTes4() {
        String jsonStr = "{\"name\":\"hv\",\"sex\":6359}";
        //JSON字符串转换成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonObject);
    }

    @Test
    @DisplayName("JSON字符串–>Java对象")
    public void jsonTes5() {
        String jsonStr = "{\"name\":\"hv\",\"sex\":6359}";
        //JSON字符串转换成JSON对象
        User user = JSONObject.parseObject(jsonStr, User.class);
        System.out.println(user);
    }

    @Test
    @DisplayName("List<Java对象>–>JSON字符串")
    public void jsonTes() {
        List<User> userList = JMockData.mock(new com.github.jsonzou.jmockdata.TypeReference<>() {
        });
        String jsonString = JSONArray.toJSONString(userList);
        System.out.println(jsonString);
    }

    @Test
    @DisplayName("JSON字符串–>List<Java对象>")
    public void jsonTes6() {
        List<User> users = JMockData.mock(new com.github.jsonzou.jmockdata.TypeReference<>() {
        });
        String jsonStr = JSONArray.toJSONString(users);
        //JSON字符串转换成Java对象
        List<User> userList = JSONArray.parseArray(jsonStr, User.class);
        System.out.println(userList);
    }


}
