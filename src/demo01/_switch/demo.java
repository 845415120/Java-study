package demo01._switch;
import java.util.Scanner;


public class demo {
    public static void main(String[] args) {
        System.out.println("请选择 :");

        System.out.println(" 1: 石头");

        System.out.println(" 2: 剪刀");

        System.out.println(" 3: 布");

        Scanner scanner = new Scanner(System.in);
        // 用户输入:
        while(true){
            int choice = scanner.nextInt();
            if (choice>=1 && choice<=3) {
                int random =(int)(1+Math.random() * 3);
                int result = choice-random;
                if (result == 2 || result == -1) {
                    System.out.println("你赢啦");
                } else if (result == -2 || result == 1) {
                    System.out.println("电脑 胜出");
                } else if (result == 0) {
                    System.out.println("eqre");
                } else {
                    System.out.println("input error");
                }
            } else {
                System.out.println("input error");
                continue;
            }
            }

            }
    }

