package ch05;

/**
 * Created by July on 2017/6/9.
 */
public class PersonTest2 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(20);
        p.setName("李刚");
        System.out.println("p对象的age值为：" + p.getAge() + " p对象的name值为：" + p.getName());
    }
}
