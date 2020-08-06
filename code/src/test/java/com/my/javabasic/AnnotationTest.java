package com.my.javabasic;

import com.my.javabasic.annotation.CustomAnnotationInClass;
import com.my.javabasic.annotation.CustomAnnotationInRuntime;
import com.my.javabasic.annotation.CustomAnnotationInSource;
import com.my.javabasic.annotation.UseCustomAnnotation;
import com.my.javabasic.annotation.inherit.MyChildrenClass;
import com.my.javabasic.annotation.inherit.MyInheritAnnotation;
import com.my.javabasic.annotation.lookup.MyLookupClass;
import com.my.javabasic.annotation.lookup.ParentAnnotation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {

    @Test
    public void getAnnotationFromClass() {
        Annotation[] annotations = UseCustomAnnotation.class.getAnnotations();
        if (annotations.length > 0) {
            for (Annotation annotation : annotations) {
                //此处通过反射应该只能获取到注解CustomAnnotationInRuntime，只有此注解的生命周期是Runtime
                printAnnotationInfo(annotation);
            }
        }
        CustomAnnotationInRuntime annotationInRuntime = UseCustomAnnotation.class.getAnnotation(CustomAnnotationInRuntime.class);
        Assert.assertNotNull(annotationInRuntime);
        printMessage(annotationInRuntime);

        CustomAnnotationInSource annotationInSource = UseCustomAnnotation.class.getAnnotation(CustomAnnotationInSource.class);
        Assert.assertNull("Source类型的注解不应该通过反射获取到", annotationInSource);
        CustomAnnotationInClass annotationInClass = UseCustomAnnotation.class.getAnnotation(CustomAnnotationInClass.class);
        Assert.assertNull("Class类型的注解不应该通过反射获取到", annotationInClass);
    }

    @Test
    public void getAnnotationFromMethod() {
        Method[] methods = UseCustomAnnotation.class.getMethods();
        if (methods.length > 0) {
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    printAnnotationInfo(annotation);
                }
            }
        }
    }

    private void printAnnotationInfo(Annotation annotation) {
        //此处通过反射应该只能获取到注解CustomAnnotationInRuntime
        //只有此注解的生命周期是Runtime
        if (annotation instanceof CustomAnnotationInRuntime) {
            CustomAnnotationInRuntime a1 = (CustomAnnotationInRuntime) annotation;
            printMessage(a1);
        } else if (annotation instanceof CustomAnnotationInSource) {
            CustomAnnotationInSource a2 = (CustomAnnotationInSource) annotation;
            printMessage(a2);
        } else if (annotation instanceof CustomAnnotationInClass) {
            CustomAnnotationInClass a3 = (CustomAnnotationInClass) annotation;
            printMessage(a3);
        } else {
            System.out.println("不认识的注解");
        }
    }

    private void printMessage(String name, String description, int order) {
        System.out.println(String.format("Name=%s,Description=%s,Order=%s", name, description, order));
    }

    private void printMessage(CustomAnnotationInRuntime annotation) {
        printMessage(annotation.Name(), annotation.Description(), annotation.Order());
    }

    private void printMessage(CustomAnnotationInClass annotation) {
        printMessage(annotation.Name(), annotation.Description(), annotation.Order());
    }

    private void printMessage(CustomAnnotationInSource annotation) {
        printMessage(annotation.Name(), annotation.Description(), annotation.Order());
    }

    @Test
    public void getSpecificAnnotationFromMethod() {
        Method[] methods = UseCustomAnnotation.class.getMethods();
        if (methods.length > 0) {
            for (Method method : methods) {
                CustomAnnotationInRuntime annotationInRuntime = method.getDeclaredAnnotation(CustomAnnotationInRuntime.class);
                if (annotationInRuntime != null) {
                    printMessage(annotationInRuntime);
                }
            }
        }
    }

    @Test
    public void getAnnotationFromFields() {
        Field[] fields = UseCustomAnnotation.class.getFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                CustomAnnotationInRuntime annotationInRuntime = field.getDeclaredAnnotation(CustomAnnotationInRuntime.class);
                if (annotationInRuntime != null) {
                    printMessage(annotationInRuntime);
                }
            }
        }
    }

    @Test
    public void getAnnotationFromSpecificField() {
        try {
            Field nameField = UseCustomAnnotation.class.getField("name");
            CustomAnnotationInRuntime annotationInRuntime = nameField.getDeclaredAnnotation(CustomAnnotationInRuntime.class);
            if (annotationInRuntime != null) {
                printMessage(annotationInRuntime);
            }
        } catch (NoSuchFieldException e) {
            System.out.println("字段名称不对.");
        }
    }

    /**
     * 组合注解原理
     * 通过反射获取注解上的注解
     * 核心原理：递归查找，参考Spring中AnnotationUtils.findAnnotation方法
     * Java原生没有方式可以获取到注解上的注解
     */
    @Test
    public void getAnnotationFromParentAnnotation() {
        //获取当前类及父类上的注解，包含继承的注解
        //通过getAnnotations方法获取注解上的注解
        Annotation[] annotation1 = MyLookupClass.class.getAnnotations();
        if (annotation1.length > 0) {
            for (Annotation annotation : annotation1) {
                if (annotation instanceof ParentAnnotation) {
                    System.out.println("通过getAnnotations方法获取到注解上的注解");
                }
                System.out.println("annotation name=" + annotation.annotationType().getName());
            }
        } else {
            System.out.println("通过getAnnotations方法没有获取到注解上的注解");
        }
        //获取目标类上的所有注解
        //通过getDeclaredAnnotations方法获取注解上的注解
        Annotation[] annotations2 = MyLookupClass.class.getDeclaredAnnotations();
        if (annotations2.length > 0) {
            for (Annotation annotation : annotations2) {
                if (annotation instanceof ParentAnnotation) {
                    System.out.println("通过getDeclaredAnnotations方法获取到注解上的注解");
                }
                System.out.println("annotation name=" + annotation.annotationType().getName());
            }
        } else {
            System.out.println("通过getDeclaredAnnotations方法没有获取到注解上的注解");
        }
        //通过isAnnotationPresent方法判断目标类上是否存在注解上的注解
        boolean hasAnnotation = MyLookupClass.class.isAnnotationPresent(ParentAnnotation.class);
        if (hasAnnotation) {
            System.out.println("通过方法isAnnotationPresent判断目标类上有注解上的注解");
        } else {
            System.out.println("通过方法isAnnotationPresent判断目标类上没有注解上的注解");
        }
        //通过Spring的AnnotationUtils.findAnnotation方法获取注解上的注解
        ParentAnnotation annotations3 = AnnotationUtils.findAnnotation(MyLookupClass.class, ParentAnnotation.class);
        if (annotations3 != null) {
            System.out.println("通过AnnotationUtils.findAnnotation方法获取到注解上的注解ParentAnnotation");
            System.out.println("Annotation name=" + annotations3.annotationType().getName());
        } else {
            System.out.println("通过AnnotationUtils.findAnnotation方法没有获取到注解上的注解ParentAnnotation");
        }
    }

    /**
     * 验证注解继承特性，如果自定义注解被元注解@Inherit标注，则反射子类，应该能获取到父类上标注的自定义注解
     */
    @Test
    public void validateAnnotationInherit() {
        Annotation[] annotations = MyChildrenClass.class.getAnnotations();
        System.out.println("Annotation count is：" + annotations.length);
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(i + ", " + annotations[i].getClass().getName());
        }
        Annotation[] annotations1 = MyChildrenClass.class.getDeclaredAnnotations();
        if (annotations1.length > 0) {
            System.out.println("Find annotation on subclass  ");
        } else {
            System.out.println("Have no one annotation on current class.");
        }
        boolean hasAnnotation = MyChildrenClass.class.isAnnotationPresent(MyInheritAnnotation.class);
        if (hasAnnotation) {
            System.out.println("Find annotation on subclass MyChildrenClass.");
        }
    }
}
