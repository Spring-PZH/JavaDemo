import concurrency.ThreadDemo;
import streams.Genre;
import streams.Movie;
import streams.StreamsDemo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0;i < 15;i++){
            Thread thread = new Thread(() -> {
                System.out.println("DAF~~~"+Thread.currentThread().getName());
            });


            System.out.println("              d**********"+thread.getName());
            System.out.println(Thread.activeCount());

            thread.start();
            thread.interrupt();
            if (thread.isInterrupted()){break;}

        }
//        ThreadDemo.show();

        var test = Runtime.getRuntime().availableProcessors();
        System.out.println(test+"~"+Thread.activeCount());

        var movies = List.of(
                new Movie("a",10, Genre.THRILLER),
                new Movie("b",20,Genre.COMEDY),
                new Movie("c",20,Genre.COMEDY)
        );
        var result = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(Movie::getTitle,Collectors.joining("和") )));
        System.out.println(result);

        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
        var thread1 = new Thread(()->collection.addAll(List.of(1,2,3)));
        var thread2 = new Thread(()->collection.addAll(List.of(5,18,12)));
        thread2.start();
        thread1.start();
        try {
            thread1.join();thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(collection);

        var sites = new ArrayList<String>();
//        sites.addAll((Arrays.asList("1we","341f","21","3")));
        String[] atr = {"1","2","4"};
//        List<String> sites3 = Arrays.asList(atr);//不add不报错，一add就报错
        List<String> sites3 = new ArrayList<>(List.of(atr));
        sites3.add("666");

        var sites2 = new ArrayList<String>(List.of("1we","341f","21","3"));
        sites2.add("666");
        Collections.addAll(sites2,atr);
        sites.addAll(sites2);
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
//        for (String i : sites) {
//            System.out.println(i);
//        }
        System.out.println(sites2);

        Map<Integer, String> map = new HashMap<>();

        StreamsDemo.show();
//        LambdasDemo.show();
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        IntBinaryOperator operator = (a, b) -> a > b ? a : b;
//        BinaryOperator<Integer> add = (a, b) -> a + b;
//        Function<String,String> map = x -> x.toUpperCase();
//        Function<String,String> map2 = x -> x.repeat(2);
//        System.out.println(map2.apply("Alice"));
//        var result = map.andThen(map2).apply("Bob");
//
//        Consumer<String> test = System.out::println;
//        test.accept("jhseofg njkoefgnojksdkjlfgsjhlifghljio ksefhgjuoi");
//        Consumer<String> print = item -> System.out.println(item.toUpperCase());
//        names.forEach(print);
//        names.forEach(System.out::println);
//        names.forEach(name -> System.out.printf(name));

    }
}
