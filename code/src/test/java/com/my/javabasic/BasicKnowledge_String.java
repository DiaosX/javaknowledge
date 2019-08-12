package com.my.javabasic;

import com.my.javabasic.basicknowledge.StringKnowledge;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_String {
    /**
     * 比较两种String对象
     */
    @Test
    public void compareString() {
        StringKnowledge str = new StringKnowledge();
        str.stringCompare();
    }


    @Test
    public void testStringBuilderContact() {
        StringKnowledge str = new StringKnowledge();
        str.stringBuilderContact();

    }

    @Test
    public void testStringBufferContact() {
        StringKnowledge str = new StringKnowledge();
        str.stringBuilderContact();
    }

    @Test
    public void frequentInterviewQuestions1() {
        StringKnowledge str = new StringKnowledge();
        str.frequentInterviewQuestions1();
    }

    @Test
    public void frequentInterviewQuestions2() {
        StringKnowledge str = new StringKnowledge();
        str.frequentInterviewQuestions2();
    }

    @Test
    public void frequentInterviewQuestions3() {
        StringKnowledge str = new StringKnowledge();
        str.frequentInterviewQuestions3();
    }

    @Test
    public void frequentInterviewQuestions4() {
        StringKnowledge str = new StringKnowledge();
        str.frequentInterviewQuestions4();
    }

    @Test
    public void testStringIntern() {
        StringKnowledge str = new StringKnowledge();
        str.stringIntern();
    }
}
