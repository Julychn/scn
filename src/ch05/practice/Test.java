package ch05.practice;

import ch05.practice.place.*;
import ch05.practice.person.*;

/**
 * 测试类
 * Created by July on 2017/6/11.
 */
public class Test {
    public static void main(String[] args) {
        School tzc = new School("台州学院", "东方大道605号");
        System.out.println(tzc.getSchoolName());
        System.out.println(tzc.getAddress());

        Teacher Lee = new Teacher();
        Lee.setSchool(tzc);
        Lee.setAge(35);
        Lee.setGender("男");
        Lee.setName("李老师");
        System.out.println(Lee.getName() + " " + Lee.getSchoolName());

        Teacher chen = new HeadTeacher("14信管", tzc, "陈老师", 45, "男");
        chen.eat();
        chen.test();
    }
}
