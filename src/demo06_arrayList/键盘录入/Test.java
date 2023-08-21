package demo06_arrayList.键盘录入;

import demo06_arrayList.Class.Students;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        创建集合对象
        ArrayList<Students> list = new ArrayList<>();
//        键盘录入
        Students stu1 = getStudent();
        Students stu2 = getStudent();
        Students stu3 = getStudent();
//        往集合中添加学生对象
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
//        遍历
        for (int i = 0; i < list.size() ; i++) {
                Students stu = list.get(i);
            System.out.println(stu.getName()+"..."+stu.getAge());

        }
    }

    private static Students getStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        //创建学生对象,把键盘录入的数据赋值传给学生对象的成员变量
        Students stu = new Students(name,age);

        return stu;
    }
}
