package com.tutorialspring.SpringLearn;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring
 * @date 2019/12/8 14:57
 */
public class BeanFactoroyTest {
    public static void main(String[] args) {
        // 1. 利用XmlBeanFactory()API去生成工厂bean，利用 ClassPathResource() API 去加载在路径 CLASSPATH 下可用的 bean 配置文件
        // 2. XmlBeanFactory() API 负责创建并初始化所有的对象，即在配置文件中提到的 bean
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));

        // 利用 bean 工厂对象的 getBean() 方法得到所需要的 bean，该方法通过配置文件中的 bean ID 来返回一个真正的对象
        // 一旦得到这个对象，就可以利用这个对象来调用任何方法。
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMsg();
    }
}
