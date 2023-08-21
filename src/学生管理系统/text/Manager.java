package 学生管理系统.text;

import 学生管理系统.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        // 2.键盘录入
        Scanner sc = new Scanner(System.in);
        // 3.创建集合容器
        ArrayList<Student> list = new ArrayList<>();

       lo: while(true){
            //1.搭建主界面
            System.out.println("______欢迎来到学生管理系统_______");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择");

            String choice =  sc.next();
            switch(choice){
                case "1":
//                    System.out.println("添加学生");
                    addStudents(list);
                    break;
                case "2":
//                    System.out.println("删除学生");
                   deleteStudent(list);
                   
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(list);
                    break;
                case "4":
//                    System.out.println("查看学生");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢使用");
                    break lo;
                default:
                    System.out.println("输入有误");
                    break;
            }

        }


    }

    public static void updateStudent(ArrayList<Student> list) {
        System.out.println("请输入您要修改的学号");
//    键盘录入
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
//        调用getIndex()
        int index = getIndex(list,updateSid);
//        判断
        if (index == -1){
            System.out.println("学号不存在");
        }else{
//           接受新的学生信息
            System.out.println("请输入新的学生姓名");
            String name = sc.next();
            System.out.println("请输入新的学生年龄");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日");
            String brithday = sc.next();
//            封装为新的学生对象
            Student stu = new Student(updateSid,name,age,brithday);
            list.set(index,stu);
            System.out.println("修改成功!!");

        }
    }
    public static void deleteStudent(ArrayList<Student> list) {
    System.out.println("请输入您要删除的学号");
//    键盘录入
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
//        调用getIndex()
        int index = getIndex(list,deleteSid);
//        判断
        if (index == -1){
            System.out.println("学号不存在");
        }else{
        list.remove(index);
            System.out.println("删除成功!");
        }
    }

    //查看学生的方法
    public static void queryStudent(ArrayList<Student> list) {
//        1.判断是否有数据
        if(list.size() == 0 ){
            System.out.println("无信息,请重新添加");
            return;
        }
//        存在
        System.out.println("学号\t\t 姓名\t 年龄 \t生日");
//        遍历集合打印学生信息
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getBirthday());
        }
    }
//    添加学生的方法

    public static void addStudents(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
//        1.给出录入的提示信息
//        学号重复
        String sid ;
        while (true){
            System.out.println("请输入学号");
            sid = sc.next();
            int index = getIndex(list,sid);
            if(index == -1 ){
                break;
            }
        }

        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入生日");
        String birthday = sc.next();
//        2.将键盘录入的信息封装为学生对象
        Student stu = new Student(sid,name,age,birthday);
//        3.将封装好的学生对象,添加到集合容器中
        list.add(stu);

//        4.给出添加成功的提示信息
        System.out.println("录入成功!");
    }


//    getindex 查找学号,在集合中的位置,看是否存在
    public static int getIndex(ArrayList<Student> list,String sid){
//        假设学号不存在
        int index = -1;
//        遍历集合,获取学号
        for (int i = 0; i < list.size() ; i++) {
            Student stu = list.get(i);
//  获取每一个学生对象的学号
            String id = stu.getSid();
// 使用获取出的学生学号,和传入的学号进行比对
            if(id.equals(sid)){
//                存在
                index = i;
            }
        }
        return  index;
    }
}
