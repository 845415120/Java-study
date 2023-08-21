
package demo03.if_;
import java.util.Scanner;
public class demo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入体重:");
        double kg = sc.nextDouble();
        System.out.println("请输入身高:");
        double m = sc.nextDouble();

        if ( kg >0 && m>0){
            double BMI = kg/(m*m);
            if (BMI<18.5){
                System.out.println("过轻");
            }else if (BMI>=18.5 && BMI<25){
                System.out.println("正常");
            }else if (BMI>=25 && BMI<28){
                System.out.println("过重");
            }else if (BMI>=28 && BMI<32){
                System.out.println("肥胖");
            }else if(BMI > 32){
                System.out.println("非常肥胖");
            }
        }
    }

}

