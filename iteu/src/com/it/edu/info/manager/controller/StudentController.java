package com.it.edu.info.manager.controller;

import com.it.edu.info.manager.domain.Student;
import com.it.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();

    private  Scanner sc = new Scanner(System.in);
    // 面板
    public void start() {
        //

        studentloop:while (true){
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
           switch (choice){
                case"1":
                    addStudent();
                    break;
                case"2":
                    deleteStudentById();                    break;
                case"3":
                    updateStudent();

                    break;
                case"4":
                    findAllStudent();
                    break;
                case"5":
                    System.out.println("感谢使用,再见");
                    break studentloop;
                default:
                    System.out.println("您的输入有误,请重新输入");
                    break;
            }
        }

    }
//修改方法
public void updateStudent() {
        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        studentService.updateStudent(updateId, newStu);

        System.out.println("修改成功!");
    }
    // 删除学生方法
    public void deleteStudentById() {
        String delId = inputStudentId();
        // 3. 调用业务员中的deleteStudentById根据id, 删除学生
        studentService.deleteStudentById(delId);
        // 4. 提示删除成功
        System.out.println("删除成功!");
    }
    // 查看学生方法
    public void findAllStudent() {
        // 1. 调用业务员中的获取方法, 得到学生的对象数组
        Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址, 是否为null
        if (stus == null){
            System.out.println("查无信息, 请添加后重试");
            return;
        }
        // 3. 遍历数组, 获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }

        }
    }
    //添加学生方法
    public void addStudent() {
//        StudentService studentService = new StudentService();
//
//        Scanner sc = new Scanner(System.in);
        String id;
        //1.键盘接受学生信息
        while (true){
            System.out.println("请输入学生id");
            id = sc.next();
            boolean flag =  studentService.isExists(id);
            if (flag){
                System.out.println("学号已经存在,请重新输入");
            }else{
                break;
            }
        }

        Student stu = inputStudentInfo(id);
        boolean result = studentService.addStudent(stu);
        //
        if (result){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");

        }
    }
    // 键盘录入学生信息
    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在, 请重新输入:");
            } else {
                break;
            }
        }
        return id;
    }
    public Student inputStudentInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}

