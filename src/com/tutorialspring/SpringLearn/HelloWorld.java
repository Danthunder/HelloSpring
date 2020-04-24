package com.tutorialspring.SpringLearn;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring
 * @date 2019/10/31 10:08
 */
public class HelloWorld {
    private String msg;

    public void getMsg() {
        System.out.println("My Message:" + msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void init() {System.out.println("Bean is going through init.");}

    public void destroy() {System.out.println("Bean will destroy now.");}

}
