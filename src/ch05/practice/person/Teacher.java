package ch05.practice.person;

import ch05.practice.place.School;

/**
 * 老师类，集成普通人类
 * Created by July on 2017/6/11.
 */
public class Teacher extends Person {
    private School school;

    public Teacher() {}
    public Teacher(School school, String name, int age, String gender) {
        super(name, age, gender);
        this.school = school;
    }

    public String getSchoolName() {
        return school.getSchoolName();
    }
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * 老师教书方法
     * @param cName  老师上课的课程名
     */
    public void teach(String cName) {
        System.out.println("老师在教" + cName);
    }

    /**
     * 老师吃东西方法
     */
    public void eat() {
        System.out.println("老师在吃东西");
    }

    /**
     * 普通老师特有的方法
     */
    public void test() {
        System.out.println("普通老师特有的方法");
    }
}
