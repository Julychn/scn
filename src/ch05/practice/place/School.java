package ch05.practice.place;

/**
 * 学校类
 * Created by July on 2017/6/11.
 */
public class School {
    private String schoolName;
    private String address;

    public School() {}
    public School(String schoolName, String address) {
        this.schoolName = schoolName;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

}
