package com.tutorialspring.other;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring
 * @date 2019/10/31 10:08
 */
class M {}

public class MainApp {
    public static void main(String[] args) {
        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();

        WeakReference<M> m = new WeakReference<M>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
//        FileSystemXmlApplicationContext
//        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
//        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//        obj.getMsg();
//        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
//        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
//        obj.getMsg();
        try {
//            Class my = Class.forName("com.tutorialspring.other.Student");
//            Field[] declaredFieldList = my.getDeclaredFields();
//            Field[] fieldList = my.getFields();
//            for (Field declaredField : declaredFieldList) {
//                System.out.println("Declared Field: " + declaredField);
//            }
//            for (Field declaredField : fieldList) {
//                System.out.println("Public Field: " + declaredField);
//            }

//            Constructor[] declaredConsList = my.getDeclaredConstructors();
//            Constructor[] consList = my.getConstructors();
//            for (Constructor declaredCons : declaredConsList) {
//                System.out.println("Declared Constructor: " + declaredCons);
//            }
//            for (Constructor cons : consList) {
//                System.out.println("Public Constructor: " + cons);
//            }


//            Method[] declaredMethodList = my.getDeclaredMethods();
//            Method[] methodList = my.getMethods();
//            for (Method declaredMethod : declaredMethodList) {
//                System.out.println("Declared Method: " + declaredMethod);
//            }
//            for (Method method : methodList) {
//                System.out.println("Public Method: " + method);
//            }

            // 1.通过字符串获取Class对象，这个字符串必须带上完整路径名
//            Class studentClass = Class.forName("com.tutorialspring.other.Student");

            // 2.获取声明的构造方法，传入所需参数的类名，如果有多个参数，用','连接即可
//            Constructor myCons = my.getDeclaredConstructor(String.class, int.class);
            // 如果是私有的构造方法，需要调用下面这一行代码使其可使用，公有的构造方法则不需要下面这一行代码
//            myCons.setAccessible(true);
            // 使用构造方法的newInstance方法创建对象，传入构造方法所需参数，如果有多个参数，用','连接即可
//            Object student = myCons.newInstance("wang",10);

            // 3.获取声明的字段，传入字段名
//            Field studentAgeField = studentClass.getDeclaredField("studentAge");
            // 使用字段的set方法设置字段值，传入此对象以及参数值
//            studentAgeField.setInt(student,20);
//            Field studentNameField = studentClass.getDeclaredField("studentName");
//            studentNameField.setAccessible(true);
//            studentNameField.set(student,"zhao");

            // 4.获取声明的函数，传入所需参数的类名，如果有多个参数，用','连接即可
//            Method studentShowMethod = studentClass.getDeclaredMethod("show",String.class);
            // 如果是私有的函数，需要调用下面这一行代码使其可使用，公有的函数则不需要下面这一行代码
//            studentShowMethod.setAccessible(true);
            // 使用函数的invoke方法调用此函数，传入此对象以及函数所需参数，如果有多个参数，用','连接即可。函数会返回一个Object对象，使用强制类型转换转成实际类型即可
//            Object result = studentShowMethod.invoke(student,"message!");
//            System.out.println("result: " + result);



//            Class my1 = Student.class;
//            Class my2 = new Student("wang",1).getClass();
//            System.out.println("class1 = " + my + "\n" +
//                    "class2 = " + my1 + "\n" +
//                    "class3 = " + my2 + "\n" +
//                    "class1 == class2 ? " + (my == my1) + "\n" +
//                    "class2 == class3 ? " + (my1 == my2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
