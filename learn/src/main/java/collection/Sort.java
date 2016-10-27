package collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by songxu on 2016/10/26.
 */
public class Sort {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(new Integer[]{1,2,10,-1,26,-2,-4});

        /**
         * 排序（默认升序）
         */
        list=list.stream().sorted().collect(Collectors.toList());
        /**
         * 降序
         */
        list=list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));


        /**
         * 数据分块
         * 利用collect partitioningBy  传入一个条件表达式Predicate
         * 返回值是一个map, key为true表示符合条件的
         */
        System.out.println("数据分块======");

        Map<Boolean,List<Integer>> result= list.stream().collect(Collectors.partitioningBy(integer -> integer > 0));

        System.out.println("大于0的数："+Arrays.toString(result.get(true).toArray()));
        System.out.println("小于0的数："+Arrays.toString(result.get(false).toArray()));



    }
}
