package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(5);
        l.add(54);
        l.add(12);
        l.add(77);
        l.add(0);

        Stream<Integer> s = l.stream();
        List<Integer> l2 = s.sorted().collect(Collectors.toList());
        System.out.println(l2);
        boolean b = l.stream().anyMatch((v) -> v == 225);
        System.out.println(b);
    }

}
