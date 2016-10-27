package parallel;

import basic.Album;
import basic.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * 并行化操作
 *
 * 并行的意思是利用多核 平行的计算
 * 与并发的概念不同
 */
public class Parallel {


    public static void main(String[] args) {

        List<Album> albums = new ArrayList<>();

        /**
         * 例如需要求一个专辑所有曲目的长度
         */

        /**
         * 非并行化计算
         */
        albums.stream().flatMap(Album::getTracks).mapToInt(Track::getLength).sum();
        /**
         * 并行化计算
         */
        albums.parallelStream().flatMap(Album::getTracks).mapToInt(Track::getLength).sum();

        /**
         * 并行化数组操作
         */
        Integer integers[]=new Integer[10];
        Arrays.parallelSetAll(integers, i->i);



    }

}
