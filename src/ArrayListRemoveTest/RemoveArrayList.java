package ArrayListRemoveTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveArrayList {
    private static Boolean noZero(Integer i){
        return i > 0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(5);
        list.add(7);


        list.stream().map(n -> n+5).toList();


        Set<Integer> set = new HashSet<>();

        set.add(4);
        set.add(5);
        set.add(4);

        System.out.println(set);
    }
}
