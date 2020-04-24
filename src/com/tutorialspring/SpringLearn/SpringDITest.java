package com.tutorialspring.SpringLearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring.SpringLearn
 * @date 2019/12/9 22:48
 */
public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanDITest.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();
    }

}
