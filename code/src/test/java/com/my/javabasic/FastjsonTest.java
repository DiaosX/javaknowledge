package com.my.javabasic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.my.javabasic.fastjson.Address;
import com.my.javabasic.fastjson.ResponseT;
import com.my.javabasic.fastjson.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FastjsonTest {

    @Test
    public void serializePlainObject() {
        Address address = new Address();
        address.setCity("shanghai");
        User user = new User();
        user.setAddress(address);
        user.setName("yst");
        user.setAge(10);
        user.setDescription("自由");
        String result = JSON.toJSONString(user);
        System.out.println(result);
    }

    /**
     * 反序列化普通对象
     */
    @Test
    public void deserializePlainObject() {
        String originalString = "{\"address\":{\"city\":\"shanghai\",\"postCode\":0},\"age\":10,\"description\":\"自由\",\"name\":\"yst\"}";
        User user = JSON.parseObject(originalString, User.class);
        if (user != null) {
            System.out.println("name=" + user.getName());
            System.out.println(user.getAddress().toString());
        }
    }

    @Test
    public void serializeGenericTypeObject() {
        ResponseT<String> response = ResponseT.success("success");
        String result = JSON.toJSONString(response);
        System.out.println(result);
    }

    /**
     * 反序列化泛型对象
     */
    @Test
    public void deserializeGenericTypeObject() {
        String originalString = "{\"data\":\"success\",\"success\":true}";
        TypeReference<ResponseT<String>> referenceT = new TypeReference<ResponseT<String>>() {
        };
        ResponseT<String> responseT = JSON.parseObject(originalString, referenceT);
        if (responseT != null) {
            System.out.println("success=" + responseT.getSuccess());
            System.out.println("data=" + responseT.getData());
        }
    }
}

