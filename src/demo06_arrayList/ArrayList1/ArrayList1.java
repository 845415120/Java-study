package demo06_arrayList.ArrayList1;
import java.util.ArrayList; // 引入 ArrayList 类


public class ArrayList1 {
    public static void main(String[]args){


//        创建
        ArrayList<String> list =new ArrayList<>(); // 初始化
        //        调用
        list.add("123");
        list.add("Google");
        list.add("Runoob");
        list.add("Taobao");
        list.add("Weibo");
        list.set(2,"2");//修改元素
        list.remove(3); // 删除第四个元素
        System.out.println(list.get(1)); //get() 访问元素
        System.out.println(list);
//        计算大小
        System.out.println(list.size());
//        迭代数组列表
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
