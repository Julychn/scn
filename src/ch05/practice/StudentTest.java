package ch05.practice;

/**
 * 课后练习第2题
 * Created by July on 2017/6/10.
 */
public class StudentTest {
    private static Student[] students = new Student[10];

    public static void main(String[] args) {
        // 初始化学生数组，添加学生
        initStu(students);
        Student s = findStu(students, "stu5", "stu5@tzc.com", "14-315");
        if (s != null) {
            System.out.println("该学生姓名为：" + s.getName());
        } else {
            System.out.println("抱歉，您输入的信息有误。");
        }

    }

    /**
     * 初始化学生数组，随机添加学生
     */
    private static void initStu(Student[] stus) {
        for (int i = 0; i < students.length; i++) {
            // 定义性别
            String gender = (i%2) == 0 ? "男" : " 女";
            // 创建一个学生对象，并添加到学生数组
            Student stu = new Student("stu" + i, i, gender, "66611" + i, "14-31" + i, "stu" + i + "@tzc.com");
            stus[i] = stu;
        }
    }

    private static Student findStu(Student[] students, String name, String email, String address) {
        for (Student stu : students) {
            if (stu.getName().equals(name) && stu.getEmail().equals(email) && stu.getAddress().equals(address)) {
                return stu;
            }
        }
        return null;
    }
}
