package com.my.javabasic.generic;

/*
JDK1.5中引入泛型

泛型的类型参数只能是引用类型，不能是简单类型

泛型限定：
上限：CustomGenericType<T extends Number>，T必须是Number的子类
下限：CustomGenericType<T super Number> ,T 必须是某个类型的父类

异常中使用泛型的问题：

不能抛出也不能捕获泛型类的对象。事实上，泛型类扩展Throwable都不合法
不能在catch子句中使用泛型变量

 */

/*
泛型类型擦除不是全部擦除，只是在编译时擦除
类型参数保留在Signature和LocalVariableTypeTable中，
可以利用class类的getGenericSuperClass()方法可以在泛型类中获取具体传入的参数类型，
本质上通过signature和LocalVariableTypeTable来获取的
 */


/*
如果是继承基类而来的泛型，就用 getGenericSuperclass() , 转型为 ParameterizedType 来获得实际类型
如果是实现接口而来的泛型，就用 getGenericInterfaces() , 针对其中的元素转型为 ParameterizedType 来获得实际类型
我们所说的 Java 泛型在字节码中会被擦除，并不总是擦除为 Object 类型，而是擦除到上限类型
能否获得想要的类型可以在 IDE 中，或用 javap -v <your_class>   来查看泛型签名来找到线索
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
泛型类
 */
public class CustomGenericType<T> {
    protected final Type type;

    public CustomGenericType() {
        Type superClass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        this.type = type;
    }

    public CustomGenericType(T data) {
        this();
        this.data = data;

    }

    public T data;

    public T getData() {
        return this.data;
    }

    public void pringActualGenericTypeParameterType() {
        System.out.println(type);
    }

    public Type getType() {
        return type;
    }
}



/*
泛型方法
 */

class StringUtil {
    public static <T> int printHashCode(T type) {
        System.out.println("hashCode=" + type.hashCode());
        return type.hashCode();
    }
}
