package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream
 */
public class IntevelIterator_Stream {

    static List<String> lists = new ArrayList<>();
    static {
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("2");
        lists.add("1");
    }

    public static void main(String[] args) {

        /**
         * 一句话代替for循环
         */
        /**
         * 每种操作都对应 Stream 接口的一个方法。
         * 为了找出来自伦敦的艺术家，需要对 Stream 对象进行过滤：
         * filter。过滤在这里是指“只保留通过某项测试的对象”。
         * 测试由一个函数完成，根据艺术家是否来自伦敦，该函数返回 true 或者 false。
         * 由于 Stream API 的函数式编程风格，我们并没有改变集合的内容，
         * 而是描述出 Stream 里的内容。count() 方法计算给定 Stream 里包含多少个对象。
         */
        long count=lists.stream().filter(s -> s.equals("2")).count();

        /**
         * 下面代码如果不加最后的count,将不会有任何输出
         * 而加上count,则会遍历6,并统计出count值为5
         * filter实际是一个stream的描述，没有产生新的集合，这称为惰性求值方法，返回值为Stream
         * count则会从Stream中计算一个值 这称为及早求值法
         */
        lists.stream().filter(s -> {
            System.out.println("这个值等于1");
            return  s.equals(1);
        }).count();

        System.out.print(count);
    }

}
