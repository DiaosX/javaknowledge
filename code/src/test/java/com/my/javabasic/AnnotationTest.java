package com.my.javabasic;

import com.my.javabasic.annotation.CustomAnnotationInClass;
import com.my.javabasic.annotation.CustomAnnotationInRuntime;
import com.my.javabasic.annotation.CustomAnnotationInSource;
import com.my.javabasic.annotation.UseCustomAnnotation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
        if (annotations != null && annotations.length > 0) {
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
        if (methods != null && methods.length > 0) {
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
        if (methods != null && methods.length > 0) {
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
        if (fields != null && fields.length > 0) {
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
            if (nameField != null) {
                CustomAnnotationInRuntime annotationInRuntime = nameField.getDeclaredAnnotation(CustomAnnotationInRuntime.class);
                if (annotationInRuntime != null) {
                    printMessage(annotationInRuntime);
                }
            }
        } catch (NoSuchFieldException e) {
            System.out.println("字段名称不对.");
        }
    }
}
