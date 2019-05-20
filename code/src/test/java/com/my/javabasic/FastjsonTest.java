package com.my.javabasic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.my.javabasic.fastjson.*;
import org.junit.Assert;
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


    /**
     * 重复引用：一个对象出现对此
     * fastjson $ref对象重复引用检测
     * <p>
     * FastJson提供了SerializerFeature.DisableCircularReferenceDetect这个序列化选项，用来关闭引用检测。
     * 关闭引用检测后，重复引用对象时就不会被$ref代替，但是在循环引用时也会导致StackOverflowError异常。
     * <p>
     * 用法：
     * 单个方法禁用：JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
     * 全局禁用：JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
     */
    @Test
    public void testDuplicateReferenceDetect() {

        ResponseDTO dto = new ResponseDTO();

        Person[] families = new Person[2];
        Person[] strangers = new Person[2];

        //将相同的对象值赋值给不同的集合
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("p1");
        p2.setName("p2");
        families[0] = p1;
        strangers[0] = p1;
        families[1] = p2;
        strangers[1] = p2;

        dto.setFamily(families);
        dto.setStranger(strangers);

        //全局禁用循环引用检测
        //JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();

        //未关闭循环引用检查序列化后的字符串为：{"family":[{"name":"p1"},{"name":"p2"}],"stranger":[{"$ref":"$.family[0]"},{"$ref":"$.family[1]"}]}
        String result1 = JSON.toJSONString(dto);
        System.out.println(result1);
        //关闭循环引用检测后的字符串为：{"family":[{"name":"p1"},{"name":"p2"}],"stranger":[{"name":"p1"},{"name":"p2"}]}
        String result2 = JSON.toJSONString(dto, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(result2);
    }

    /**
     * 循环引用：相互引用，处理不好就引发StackOverflowError异常
     * fastjson 循环引用检测测试
     */
    @Test
    public void testCircularReferenceDetect() {

        CircularReference1 reference1 = new CircularReference1();
        reference1.setName("reference1");

        CircularReference2 reference2 = new CircularReference2();
        reference2.setName("reference2");

        reference1.setReference2(reference2);
        reference2.setReference1(reference1);

        //禁用循环引用之前，不会引发SOE异常
        String result1 = JSON.toJSONString(reference1);
        System.out.println(result1);

        //禁用循环引用之后,引发StackOverFlow异常
        try {
            String result2 = JSON.toJSONString(reference1, SerializerFeature.DisableCircularReferenceDetect);
            System.out.println(result2);
        } catch (StackOverflowError e) {
            Assert.assertTrue("异常引发不是SOE", e instanceof StackOverflowError);
        }
    }
}

