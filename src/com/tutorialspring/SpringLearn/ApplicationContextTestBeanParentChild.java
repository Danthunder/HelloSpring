package com.tutorialspring.SpringLearn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring.SpringLearn
 * @date 2019/12/8 15:08
 */
public class ApplicationContextTestBeanParentChild {
    public static void main(String[] args) {
        // 利用FileSystemXmlApplicationContext API 去生成工厂 bean，FileSystemXmlApplicationContext 负责生成和初始化所有的对象
        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\IdeaProjects\\HelloSpring\\src\\Bean.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

        // 利用上下文对象中的 getBean() 方法得到所需要的 bean。通过配置文件中的 bean ID 来返回一个真正的对象

        HelloWorldParent obj1 = (HelloWorldParent) context.getBean("HelloWorldParent");
        // 可以利用这个对象来调用任何方法
        obj1.getMsg1();
        obj1.getMsg2();

        HelloChinaChild obj2 = (HelloChinaChild) context.getBean("HelloChinaChild");
        obj2.getMsg1();
        obj2.getMsg2();
        obj2.getMsg3();


        // 需要注册一个在 AbstractApplicationContext 类中声明的关闭 hook 的 registerShutdownHook() 方法。
        // 它将确保正常关闭，并且调用相关的 destroy 方法。
        ((FileSystemXmlApplicationContext) context).registerShutdownHook();
    }
}
