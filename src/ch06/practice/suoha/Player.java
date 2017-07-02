package ch06.practice.suoha;

/**
 * Created by scn on 2017/7/2.
 * 玩家类
 */
public class Player {
    private String name;
    private String location;
    // 是否放弃，true为继续跟牌
    private boolean flag = true;
    // 玩家手中持有的牌
    private String[] pok = new String[5];

    public Player() {}
    public Player(String name, String location) {
        this.name = name;
        this.location = location;
    }
    // 重写toString()方法
    public String toString() {
        StringBuffer sb = new StringBuffer();
        // 第一张伟底牌，不能直接显示出来，故从1开始循环
        for (int i = 1; i < pok.length; i++) {
            sb.append("[").append(pok[i] == null? "无" : pok[i]).append("]");
        }
        return "玩家：" + name + "，底牌：" + "[" + (pok[0] == null? "无" : pok[0]) + "]" + "牌面：" + sb.toString();
    }

    public String getInfo(String info){
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {
        return flag;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String[] getPok() {
        return pok;
    }

    public void setPok(String[] pok) {
        this.pok = pok;
    }

}
