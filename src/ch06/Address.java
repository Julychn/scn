package ch06;

/**
 * 不可变类
 * Created by July on 2017/6/12.
 */
public class Address {
    private final String detail;
    private final String postCode;
    // 在构造器里初始化两个实例变量
    public Address() {
        this.detail = "";
        this.postCode = "";
    }
    public Address(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }
    // 只提供getter方法

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }
    // 重写equals()方法
    public boolean eaquals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Address.class) {
            Address ad = (Address) obj;
            // 当detail和postCode相等时，认为两个对象相等
            if (this.getDetail().equals(ad.getDetail()) && this.getPostCode().equals(ad.getPostCode())) {
                return true;
            }
        }
        return false;
    }
    public int hashCode() {
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}
