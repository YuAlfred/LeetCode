// package Steam;
//
// import org.junit.jupiter.api.Test;
//
// import java.util.Comparator;
// import java.util.Random;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;
// import java.util.stream.Stream;
//
// /**
//  * @author alfredt
//  * @version 1.0.0
//  * @description: 基本流计算
//  * @date: 2021/5/28 3:46 下午
//  */
// public class BasicExample {
//
//
//     @Test
//     public void test_mapFilter() {
//         Stream.of(1, 2, 3, 4, 5, 6)
//             .map(x -> x.toString())
//             .map(x -> x + x)
//             .map(Integer::parseInt)
//             .forEach(x -> {
//                 System.out.println(x);
//             });
//
//     }
//
//     @Test
//     public void test_mapFilterReduce() {
//         var result = Stream.of(1, 2, 3, 4, 5, 6)
//             .map(x -> x * x)
//             .filter(x -> x < 20)
//             .reduce(0, Math::max);
//         System.out.println(result);
//     }
//
//     @Test
//     public void test_mutation() {
//         var stream = Stream.of(1, 3, 4, 6, 5, 2).sorted();
//         stream.forEach(System.out::println);
//     }
//
//     /**
//      * 字符串去除重复字母
//      */
//     @Test
//     public void test_flatMap() {
//         // 先将其转换为字母流，再收集为set，就自动去重了
//         var set = Stream.of("My", "Mine")
//             .flatMap(str -> str.chars().mapToObj(i -> (char) i))
//             .collect(Collectors.toSet());
//         System.out.println(set);
//         System.out.println(set.stream().collect(Collectors.toList()));
//     }
//
//     /**
//      * 并行计算最大值
//      */
//     @Test
//     public void test_parallel() {
//
//         var r = new Random();
//
//         var list = IntStream.range(0, 1_000_000)
//             .map(x -> r.nextInt(10_000_000))
//             .boxed()
//             .collect(Collectors.toList());
//
//         // 串行 计算最大值
//         var t0 = System.currentTimeMillis();
//         System.out.println(list.stream().max(Comparator.comparingInt(a -> a)));
//         System.out.println("time: " + (System.currentTimeMillis() - t0));
//
//         // 并行 计算最大值
//         var t1 = System.currentTimeMillis();
//         list.parallelStream().max((a, b) -> a - b);
//         System.out.println("time: " + (System.currentTimeMillis() - t1));
//     }
//
//
// }
