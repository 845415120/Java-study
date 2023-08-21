package demo06_arrayList.Array;


import demo06_arrayList.Class.Students;

/*
*将（张三，23）（李四，24）（王五，25）
* 封装为3个学生对象并存入数组
随后遍历数组，将学生信息输出在控制台
* */
public class TextObjectArray {
    public static void main(String[]args){
//2动态初始化长度为3的数组
        Students[] arr =new Students[3];
//     创建3个学生对象
        Students stu1 = new Students("张三",23);
        Students stu2 = new Students("李四",24);
        Students stu3 = new Students("王五",25);
//        将对象存入数组
        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;
//        遍历
        for (int i = 0; i < arr.length; i++) {
            Students temp =  arr[i];
            System.out.println(temp.getName()+"..."+temp.getAge());

        }
    }
}
