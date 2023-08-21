
package demo04.jiang.demo;

public class Hello {
    public static void main (String [] args){
        int age = 7;
        int ages  = 7;

        // primary student的定义: 6~12岁
        boolean isPrimaryStudent = age >= 6 && age <= 12;
        System.out.println(isPrimaryStudent ? "是" : "不是");
    }
}
