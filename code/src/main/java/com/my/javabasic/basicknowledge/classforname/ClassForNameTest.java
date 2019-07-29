package com.my.javabasic.basicknowledge.classforname;

/**
 * 测试Class.forName和ClassLoader区别
 * Class.forName加载Class时，静态块代码会被调用，而ClassLoader加载Class时，不会调用静态块
 */
public class ClassForNameTest {

    private String className = "com.my.javabasic.basicknowledge.classforname.MyTestClass";

    public void loadClassUseForName() {
        try {
            Class clazz = Class.forName(className);
            System.out.println("ClassName=" + clazz.getSimpleName());
            MyTestClass instance = (MyTestClass) clazz.newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void loadClassUseLoader() {
        try {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            Class clazz = loader.loadClass(className);
            System.out.println("ClassName=" + clazz.getSimpleName());
            MyTestClass instance = (MyTestClass) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadClassOnlyUseLoader() {
        try {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            Class clazz = loader.loadClass(className);
            System.out.println("ClassName=" + clazz.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
