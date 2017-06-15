package ch05.practice.person;

/**
 * 普通人类
 * Created by July on 2017/6/10.
 */
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {}
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 普通人吃东西方法
     */
    public void eat() {
        System.out.println("普通人吃东西");
    }

}
