package demo06_arrayList.Class;
//定义学生类,封装数据
public class Students {
    private String name;
    private int age;

    public Students() {
    }

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
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
}
