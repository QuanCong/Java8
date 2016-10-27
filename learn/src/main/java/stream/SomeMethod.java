package stream;

import basic.Artist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * 常用的流操作
 */
public class SomeMethod {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {


        String[] strs = {"a", "b", "c", "ad", "ac","a","a"};




        /**
         * Stream.of 将一个数组转换为流
         */
        Stream<String> stream = Stream.of(strs);

        System.out.println("===去重====");
        /**
         * 去重
         */
        List<String> noRepeat=Stream.of(strs).distinct().collect(Collectors.toList());
        noRepeat.forEach(str->System.out.println(str));




        /**
         * collect
         */
        List<String> collected = Stream.of(strs).collect(Collectors.toList());
        List<String> list = Arrays.asList(strs);
        System.out.println("====map=====");
        /**
         * map
         * 将流中的值改变
         * map接收一个Function参数
         */
        List<String> map = Stream.of(strs).map(s -> s + "123").collect(Collectors.toList());
        map.forEach(s -> {
            System.out.println(s);
        });

        /**
         * flatmap
         * 与map类似
         * 但是Function参数必须接受一个stream返回值
         * 它的工作可以将多个流整合为一个流
         */

        /**
         * filter
         * filter接收一个Predicate参数
         * Predicate 返回true或false
         */
        System.out.println("=====filter=====");

        Stream.of(strs).filter(s -> s.startsWith("a")).forEach(s -> {
            System.out.println(s);
        });
        System.out.println("=====max min=====");
        /**
         * max min
         * 最大最小值
         * min max 返回一个Optional对象 它代表一个可能存在也可能不存在的值
         * 如果Stream不为空，则该值存在,通过get方法得到它的值
         */
        List<Person> personList = Arrays.asList(new Person[]{new Person("sx", 25),
                new Person("mack", 26), new Person("john", 35)});

        Person person = personList.stream().
                min(Comparator.comparing(Person::getName))
                .get();
        System.out.println("年龄最小的人:" + person.getName());

        /**
         * reduce
         * 从一组值中生成一个值
         * 如 max ,min,count 本质上都是reduce
         */
        System.out.println("=====max min=====");

        System.out.println("=====nn=====");
        List<Artist> artistList = Arrays.asList(new Artist[]{
                new Artist("n1","t1"),new Artist("n2","t2"),
                new Artist("n3","t3"),new Artist("n4","t4"),
                new Artist("n3","t3"),new Artist("n6","t6"),
                new Artist("n3","t3"),new Artist("n8","t8"),
                new Artist("n3","t3"),new Artist("n10","t10"),
        });

       Set<String> set= getNameAndNation(artistList);
       System.out.println(Arrays.toString(set.toArray())); ;


    }

    /**
     * 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，
     * 其中包含艺术家的姓名和国籍；
     * @param artiss
     * @return
     */
    public static  Set<String> getNameAndNation(List<Artist> artiss) {

//        return artiss.stream().map(artist -> {
//            return artist.getName() + " " + artist.getNationality();
//        }).collect(Collectors.toSet());
        return artiss.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toSet());
    }


}
