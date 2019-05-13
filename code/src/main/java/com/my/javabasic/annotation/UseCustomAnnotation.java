package com.my.javabasic.annotation;

@CustomAnnotationInRuntime(Name = "InRuntime", Description = "从类获取", Order = 1)
@CustomAnnotationInSource(Name = "InSource", Description = "从类获取", Order = 2)
@CustomAnnotationInClass(Name = "InClass", Description = "从类获取", Order = 3)
public class UseCustomAnnotation {
    @CustomAnnotationInRuntime(Name = "InRuntime", Order = 100, Description = "从方法获取")
    @CustomAnnotationInSource(Name = "InSource", Order = 99, Description = "从方法获取")
    @CustomAnnotationInClass(Name = "InClass", Order = 98, Description = "从方法获取")
    public void printHello() {
        System.out.println("Hello Annotation.");
    }

    @CustomAnnotationInRuntime(Name = "InRuntime", Order = 1, Description = "从字段获取")
    @CustomAnnotationInSource(Name = "InSource", Order = 2, Description = "从字段获取")
    @CustomAnnotationInClass(Name = "InClass", Order = 3, Description = "从字段获取")
    public String name;
}
