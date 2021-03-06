package com.tutorialspring.SpringLearn;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspring
 * @date 2019/10/31 10:08
 */
public class HelloChinaChild {
    private String msg1;
    private String msg2;
    private String msg3;

    public void getMsg1() {
        System.out.println("HelloChinaChild msg1:" + msg1);
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public void getMsg2() {
        System.out.println("HelloChinaChild msg2:" + msg2);
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    public void getMsg3() {
        System.out.println("HelloChinaChild msg3:" + msg3);
    }

    public void setMsg3(String msg3) {
        this.msg3 = msg3;
    }

    public void init() {System.out.println("Bean is going through init.");}

    public void destroy() {System.out.println("Bean will destroy now.");}

}
