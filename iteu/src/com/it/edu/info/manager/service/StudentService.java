package com.it.edu.info.manager.service;

import com.it.edu.info.manager.dao.StudentDao;
import com.it.edu.info.manager.domain.Student;

public class StudentService {
    //创建库管
    private StudentDao studentDao = new StudentDao();
    // 添加学生方法

    public boolean addStudent(Student stu) {

        //将学生对象,传递给StudentDao,库管中的addStudent方法
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
        Student [] stus = studentDao.findAllStudent();
        //假设数组不存在
        boolean exists = false;
        for (int i = 0; i <stus.length ; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        // 1. 调用库管对象的findAllStudent获取学生对象数组
        Student[] allStudent = studentDao.findAllStudent();
        // 2. 判断数组中是否有学生信息 (有: 返回地址,  没有: 返回null)
        // 思路: 数组中只要存在一个不是null的元素, 那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }

        if(flag){
            // 有信息
            return allStudent;
        }else{
            // 没有信息
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }
    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId, newStu);
    }
}
