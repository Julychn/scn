package ch05.practice.person;

import ch05.practice.place.School;

/**
 * 学生类，继承普通人类
 * Created by July on 2017/6/11.
 */
public class Student extends Person{
    private String num;
    private School school;

    public Student() {}
    public Student(School school, String num, String name, int age, String gender) {
        super(name, age, gender);
        this.num = num;
        this.school = school;
    }



    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 学生吃东西方法
     */
    public void eat() {
        System.out.println("学生在吃东西");
    }

    /**
     * 学生学习课程方法
     * @param cName 学习的课程名
     */
    public void learn(String cName) {
        System.out.println("学生" + getName() + "在学习" + cName);
    }
}
