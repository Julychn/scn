package ch15;

import java.io.*;

/**
 * Created by scn on 2017/7/13.
 */
public class WriteObject {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ch15/object.txt"))
                ) {
            Person per = new Person("孙悟空", 500);
            // 将per对象写入输出流
            oos.writeObject(per);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Person implements Serializable {
    private String name;
    private int age;
    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
