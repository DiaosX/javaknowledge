package com.my.javabasic;

import com.my.javabasic.reflect.CustomReflectClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectTest {

    @Test
    public void getClassUseTwoWay() {
        try {
            //两种方式获取Class对象
            Class<?> clazz1 = Class.forName("com.my.javabasic.reflect.CustomReflectClass");
            Class<?> clazz2 = new CustomReflectClass().getClass();

            System.out.println("Class是否相等：" + (clazz1 == clazz2));
            Object instance1 = clazz1.newInstance();
            Object instance2 = clazz2.newInstance();
            System.out.println("Instance是否相等：" + (instance1 == instance2));
            Assert.assertTrue("不是CustomReflectClass的实例", instance1 instanceof CustomReflectClass);
            Assert.assertTrue("不是CustomReflectClass的实例", instance2 instanceof CustomReflectClass);
            CustomReflectClass realInstance = (CustomReflectClass) instance1;
            System.out.println(realInstance.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createClassInstance() {
        try {
            Class<?> clazz = Class.forName("com.my.javabasic.reflect.CustomReflectClass");
            Object instance = clazz.newInstance();
            Assert.assertTrue("不是CustomReflectClass的实例", instance instanceof CustomReflectClass);
            CustomReflectClass realInstance = (CustomReflectClass) instance;
            System.out.println(realInstance.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
      getMethods(),该方法是获取本类以及父类或者父接口中所有的公共方法(public修饰符修饰的)
      getDeclaredMethods(),该方法是获取本类中的所有方法，包括私有的(private、protected、默认以及public)的方法。
     */

    @Test
    public void getAllMethodFromClass() {
        try {
            Method[] declaredMethods = CustomReflectClass.class.getDeclaredMethods();
            System.out.println("-----------------------打印当前类中的所有方法-------------------------");
            printMethodInfo(declaredMethods);
            System.out.println("-----------------------打印父类及当前类中的所有公共方法-------------------------");
            Method[] methods = CustomReflectClass.class.getMethods();
            printMethodInfo(methods);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllFieldFromClass() {
        try {
            Field[] declaredFields = CustomReflectClass.class.getDeclaredFields();
            System.out.println("-----------------------打印当前类中的所有字段-------------------------");
            printFieldInfo(declaredFields);
            System.out.println("-----------------------打印父类及当前类中的所有字段-------------------------");
            Field[] fields = CustomReflectClass.class.getFields();
            printFieldInfo(fields);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setSpecificFieldValue() {
        try {
            Field nameField = CustomReflectClass.class.getDeclaredField("name");
            Field countField = CustomReflectClass.class.getDeclaredField("count");
            Class<?> clazz = Class.forName("com.my.javabasic.reflect.CustomReflectClass");
            Object instance = clazz.newInstance();
            CustomReflectClass realInstance = (CustomReflectClass) instance;
            System.out.println("属性设置前的值为：name=" + realInstance.getName() + "|count=" + realInstance.count);
            nameField.setAccessible(true);
            nameField.set(instance, "tony");
            //countField.setAccessible(true);
            countField.set(instance, 10);
            System.out.println("属性设置后的值为：name=" + realInstance.getName() + "|count=" + realInstance.count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printMethodInfo(Method[] methods) {
        if (methods != null && methods.length > 0) {
            for (Method method : methods) {
                String format = "方法名称:%s,返回类型:%s,修饰符:%s,默认值:%s";
                //Modifier工具类操作修饰符，总共12中修饰符
                String message = String.format(format, method.getName(), method.getReturnType().getName(), Modifier.toString(method.getModifiers()), method.getDefaultValue());
                System.out.println(message);
            }
        }
    }

    private void printFieldInfo(Field[] fields) {
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String format = "属性名称:%s,类型:%s,修饰符:%s";
                String message = String.format(format, field.getName(), field.getType().getName(), Modifier.toString(field.getModifiers()));
                System.out.println(message);
            }
        }
    }

    @Test
    public void dynamicCallMethod() {
        try {
            Method declaredMethod = CustomReflectClass.class.getDeclaredMethod("printMessage", String.class);
            Class<?> clazz = Class.forName("com.my.javabasic.reflect.CustomReflectClass");
            Object instance = clazz.newInstance();
            declaredMethod.invoke(instance, "动态调用方法");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
