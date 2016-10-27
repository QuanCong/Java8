package lamada;

import java.util.function.BinaryOperator;

/**
 * Created by songxu on 2016/10/25.
 */
public class First {


    public static void main(String[] args) {


        Runnable noArgs = () -> System.out.println("无参数的表达式");
        /**
         * lamada表达式主体是一个代码块
         */
        Runnable mulitStateMent = () -> {
            System.out.println("多个语句的表达式");
            System.out.println("语句1");
            System.out.println("语句2");
        };

        /**
         * 包含多个参数的lamada表达式
         */
        BinaryOperator<Long> add=(x,y)->x+y;

        new Thread(() -> {
            System.out.print("匿名内部类");
        }).start();
        new Thread(noArgs).start();
        new Thread(mulitStateMent).start();



    }
}
