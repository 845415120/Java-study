package com.it.edu.info.manager.dao;

import com.it.edu.info.manager.domain.Student;

public class StudentDao {
    //创建学生对象数组
   private static Student [] stus = new Student[5];

    public boolean addStudent(Student stu) {

        //添加学生到数组
        int index = -1;
        //遍历数组
        for (int i = 0; i < stus.length; i++) {
            Student student = stus [i];
            if (student == null){
                index = i;
                // 如果null,让index 变量记录当前索引位置
                break;
            }
        }
        //返回是否添加成功的Boolean类型状态
        if(index == -1){
            //装满了
            return false;
        }else {
            //没有装满
            stus[index] = stu;
            return true;
        }
    }
    // 查看学生方法
    public Student[] findAllStudent() {
    return  stus;
    }

    public void deleteStudentById(String delId) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        // 2. 将该索引位置,使用null元素进行覆盖
        stus[index] = null;
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
    public void updateStudent(String updateId, Student newStu) {
        // 1. 查找updateId, 在容器中的索引位置
        int index = getIndex(updateId);
        // 2. 将该索引位置, 使用新的学生对象替换
        stus[index] = newStu;
    }
}
