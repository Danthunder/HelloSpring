package com.tutorialspring.other;

/**
 * @author wangdanning
 * @version V1.0
 * @Package com.tutorialspoint
 * @date 2019/11/1 14:34
 */
public class Student {
    private String studentName;
    public int studentAge;

    private Student(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String show(String message) {
        System.out.println("show:" + studentName + ":" + studentAge + "---" + message);
        return "HaHaHa";
    }
}
