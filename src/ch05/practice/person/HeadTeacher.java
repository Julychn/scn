package ch05.practice.person;

import ch05.practice.place.School;

/**
 * 班主任类，继承老师类
 * Created by July on 2017/6/11.
 */
public class HeadTeacher extends Teacher {
    private String className;

    public HeadTeacher() {}
    public HeadTeacher(String className, School school, String name, int age, String gender) {
        super(school, name, age, gender);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 班主任教书方法
     * @param cname 班主任上的课程名
     */
    public void teach(String cname) {
        System.out.println("班主任在教" + cname);
    }

    /**
     * 班主任吃东西方法
     */
    public void eat() {
        System.out.println("班主任吃东西");
    }

    /**
     * 班主任和学生谈话方法
     * @param studentName 被谈话的学生姓名
     */
    public void talkToStudent(String studentName) {
        System.out.println("班主任" + getName() + "正在和学生" + studentName + "谈话");
    }
 }
