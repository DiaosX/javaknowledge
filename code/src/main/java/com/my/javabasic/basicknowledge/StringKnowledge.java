package com.my.javabasic.basicknowledge;

/**
 * StringBuilder测试
 */
public class StringKnowledge {

    /*
    String类特点，
    1.被final修饰，不可被继承
    2.String是不可变对象，每次操作都是生成一个新的对象
    3.
     */

    public void stringCompare() {
        String s1 = "Hello World";
        String s2 = new String("Hello World");
        String s3 = "Hello World";
        String s4 = new String("Hello World");

        System.out.println("s1==s2:" + (s1 == s2));
        System.out.println("s1==s3:" + (s1 == s3));
        System.out.println("s2==s3:" + (s2 == s3));
        System.out.println("s2==s4:" + (s2 == s4));
    }

    /**
     * String拼接
     */
    public void stringBuilderContact() {

        /*
        String + 被JVM优化为 new StringBuilder();
        如果大量的+操作，会创建很多的StringBuilder对象，给回收到来压力
         */

        StringBuilder builder = new StringBuilder();
        builder.append("Hello");
        builder.append(" ");
        builder.append("World");

        System.out.println("result=" + builder.toString());
    }

    /**
     * 当多线程场景字符串拼接时用StringBuffer
     */
    public void stringBufferContact() {
        /*
        StringBuffer是线程安全的，StringBuffer的操作方法前都加了synchronized关键字
         */
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello");
        buffer.append(" ");
        buffer.append("World");

        System.out.println("result=" + buffer.toString());
    }

    public void frequentInterviewQuestions1() {
        String a = "hello2";
        String b = "hello" + 2;
        System.out.println((a == b));
        //输出结果为：true。
        // 原因很简单，"hello"+2在编译期间就已经被优化成"hello2"，
        // 因此在运行期间，变量a和变量b指向的是同一个对象。
    }

    public void frequentInterviewQuestions2() {
        String a = "hello2";
        String b = "hello";
        String c = b + 2;
        System.out.println((a == c));
        //输出结果为:false。
        // 由于有符号引用的存在，
        // 所以  String c = b + 2;不会在编译期间被优化，
        // 不会把b+2当做字面常量来处理的，
        // 因此这种方式生成的对象事实上是保存在堆上的。因此a和c指向的并不是同一个对象。
    }

    public void frequentInterviewQuestions3() {
        String a = "hello2";
        final String b = "hello";
        String c = b + 2;
        System.out.println((a == c));
        //true。
        // 对于被final修饰的变量，会在class文件常量池中保存一个副本，
        // 也就是说不会通过连接而进行访问，
        // 对final变量的访问在编译期间都会直接被替代为真实的值。
        // 那么String c = b + 2;
        // 在编译期间就会被优化成：String c = "hello" + 2;
    }

    public void frequentInterviewQuestions4() {
        String a = "hello";
        String b = new String("hello");
        String c = new String("hello");

        //返回常量池中的对象，如果不存在，则将字符串加入常量池，并返回此对象的引用
        //如果存在，则直接返回常量池中的对象
        String d = b.intern();

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println(a == d);

        //这里面涉及到的是String.intern方法的使用。
        // 在String类中，intern方法是一个本地方法，
        // 在JAVA SE6之前，intern方法会在运行时常量池中查找是否存在内容相同的字符串，
        // 如果存在则返回指向该字符串的引用，如果不存在，则会将该字符串入池，
        // 并返回一个指向该字符串的引用。因此，a和d指向的是同一个对象。
    }

    public void frequentInterviewQuestions5() {
        String str = new String("abc");
        //创建几个对象
        //创建了两个对象，
    }

    public void frequentInterviewQuestions6() {
         /*
         * Java8 中优化后结果一样
         * */
        String str1 = "I";
        str1 += "love" + "java";         //1)
        //str1 = str1 + "love" + "java"; //2)

        //1)的效率比2)的效率高，1)中被
    }
}
